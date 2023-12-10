package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;
import com.example.luxurycarrentals.model.entity.Booking;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.mapper.BookingMapper;
import com.example.luxurycarrentals.repoitory.BookingRepository;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserService userService;


    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, UserService userService) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.userService = userService;
    }


    @Override
    public List<BookingDetailsDTO> findByUserId(Long userId) {

        return bookingRepository.findAllByUserEntity_Id(userId)
                .stream()
                .map(bookingMapper::bookingToBookingDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addBooking(BookingAddDTO bookingAddDTO, String username) {

        Booking booking = bookingMapper.bookingAddDTOTOBooking(bookingAddDTO);
        UserEntity user = userService.findByEmail(username);

        StringBuilder bookingNumber = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(9); // Adjust the upper bound as needed
            bookingNumber.append(randomNumber);
        }

        LocalDateTime pickUpDate = bookingAddDTO.getPickUpDate();
        LocalDateTime dropOffDate = bookingAddDTO.getDropOffDate();
        Duration bookingDuration = Duration.between(pickUpDate, dropOffDate);
        Duration hours = Duration.ofHours(8);
        Duration days = Duration.ofDays(28);

        BigDecimal chauffeurPerHour = new BigDecimal(0);

        if (booking.getChauffeur() != null) {
            chauffeurPerHour = booking.getChauffeur().getPricePerHour();
        }

        if (bookingDuration.compareTo(hours) > 0) {

            if (bookingDuration.compareTo(days) > 0) {

                BigDecimal perMonth = booking.getCar().getSpecifications().getPerMonthPrice();
                BigDecimal price = perMonth.multiply(new BigDecimal(bookingDuration.toDays() / 30));
                BigDecimal chauffeurPrice =
                        chauffeurPerHour.multiply(new BigDecimal(bookingDuration.toDays() * 8));

                BigDecimal totalPrice = price.add(chauffeurPrice);

                booking.setPrice(totalPrice);
            }else {

                BigDecimal perDay = booking.getCar().getSpecifications().getPerDayPrice();
                BigDecimal price = perDay.multiply(new BigDecimal(bookingDuration.toDays()));
                BigDecimal chauffeurPrice =
                        chauffeurPerHour.multiply(new BigDecimal(bookingDuration.toDays() * 8));

                BigDecimal totalPrice = price.add(chauffeurPrice);

                booking.setPrice(totalPrice);
            }


        }else {

            BigDecimal perHour = booking.getCar().getSpecifications().getPerHourPrice();
            BigDecimal price = perHour.multiply(new BigDecimal(bookingDuration.toHours()));
            BigDecimal chauffeurPrice = chauffeurPerHour.multiply(new BigDecimal(bookingDuration.toHours()));

            BigDecimal totalPrice = price.add(chauffeurPrice);

            booking.setPrice(totalPrice);
        }

        booking.setUser(user);
        booking.setBookingNumber(bookingNumber.toString());

        bookingRepository.save(booking);
        user.getBookings().add(booking);
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void removeExpiredBookings() {

        LocalDate today = LocalDate.now();
        List<Booking> expiredBookings = bookingRepository.findAllByDropOffDateBefore(today);

        for (Booking booking : expiredBookings) {

            booking.setCar(null);
            booking.setUser(null);
            bookingRepository.delete(booking);
        }
    }
}

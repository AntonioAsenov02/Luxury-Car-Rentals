package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;
import com.example.luxurycarrentals.model.entity.Booking;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.mapper.BookingMapper;
import com.example.luxurycarrentals.repoitory.BookingRepository;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {


    private BookingService serviceToStart;

    @Mock
    private BookingRepository mockBookingRepository;

    @Mock
    private BookingMapper mockBookingMapper;

    @Mock
    private UserService mockUserService;


    @BeforeEach
    void setUp() {

        serviceToStart = new BookingServiceImpl(mockBookingRepository, mockBookingMapper, mockUserService);
    }



    @Test
    void testFindByUserId() {
        // Arrange
        Long userId = 1L;

        Booking booking1 = creatBooking();

        List<Booking> mockBookings = Arrays.asList(booking1);

        BookingDetailsDTO bookingDetailsDTO1 = createBookingDetailsDTO();

        List<BookingDetailsDTO> expectedBookingDetailsDTOs = Arrays.asList(bookingDetailsDTO1);

        // Mock the behavior of bookingRepository
        when(mockBookingRepository.findAllByUserEntity_Id(userId)).thenReturn(mockBookings);

        // Mock the behavior of bookingMapper
        when(mockBookingMapper.bookingToBookingDetailsDTO(booking1)).thenReturn(bookingDetailsDTO1);

        // Act
        List<BookingDetailsDTO> result = serviceToStart.findByUserId(userId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedBookingDetailsDTOs.size(), result.size());
        assertEquals(booking1.getCar().getBrand(), bookingDetailsDTO1.getCarBrand());
        assertEquals(booking1.getCar().getModel(), bookingDetailsDTO1.getCarModel());
        assertEquals(booking1.getChauffeur().getName(), bookingDetailsDTO1.getChauffeurName());
        assertEquals(booking1.getChauffeur().getSurname(), bookingDetailsDTO1.getChauffeurSurname());
        assertEquals(booking1.getBookingNumber(), bookingDetailsDTO1.getBookingNumber());
        assertEquals(booking1.getPickUpLocation(), bookingDetailsDTO1.getPickUpLocation());
        assertEquals(booking1.getDropOffLocation(), bookingDetailsDTO1.getDropOffLocation());
        assertEquals(booking1.getPickUpDate(), bookingDetailsDTO1.getPickUpDate());
        assertEquals(booking1.getDropOffDate(), bookingDetailsDTO1.getDropOffDate());


        // Verify that bookingRepository method was called
        verify(mockBookingRepository).findAllByUserEntity_Id(userId);

        // Verify that bookingMapper method was called for each booking
        verify(mockBookingMapper, times(mockBookings.size()))
                .bookingToBookingDetailsDTO(any());

        // Assert the order of results
        assertEquals(expectedBookingDetailsDTOs, result);
    }

    @Test
    public void testRemoveExpiredBookings() {
        // Arrange
        LocalDate today = LocalDate.now();
        Booking expiredBooking = creatBooking();
        List<Booking> expiredBookings = Arrays.asList(expiredBooking);

        when(mockBookingRepository.findAllByDropOffDateBefore(today)).thenReturn(expiredBookings);

        // Act
        serviceToStart.removeExpiredBookings();

        // Assert
        verify(mockBookingRepository, times(1)).findAllByDropOffDateBefore(today);
        verify(mockBookingRepository, times(1)).delete(expiredBooking);
    }

    private Booking creatBooking() {

        Booking booking = (Booking) new Booking().setId(1L);

        return booking.setBookingNumber("1234567")
                .setPickUpDate(LocalDateTime.of(2023, Month.DECEMBER, 14, 12,0))
                .setDropOffDate(LocalDateTime.of(2023, Month.DECEMBER, 15, 12,0))
                .setPickUpLocation("Sofia")
                .setDropOffLocation("Sofia")
                .setPrice(BigDecimal.valueOf(1000)).setCar(new Car()
                        .setBrand("Mercedes")
                        .setModel("S-class"))
                .setChauffeur(new Chauffeur()
                        .setName("Frank")
                        .setSurname("Martin"));
    }

    private BookingDetailsDTO createBookingDetailsDTO() {

        return  new BookingDetailsDTO()
                .setBookingNumber("1234567")
                .setPickUpDate(LocalDateTime.of(2023, Month.DECEMBER, 14, 12,0))
                .setDropOffDate(LocalDateTime.of(2023, Month.DECEMBER, 15, 12,0))
                .setPickUpLocation("Sofia")
                .setDropOffLocation("Sofia")
                .setPrice(BigDecimal.valueOf(1000))
                .setCarBrand("Mercedes")
                .setCarModel("S-class")
                .setChauffeurName("Frank")
                .setChauffeurSurname("Martin");
    }
}
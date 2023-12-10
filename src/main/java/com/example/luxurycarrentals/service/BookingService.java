package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;

import java.util.List;

public interface BookingService {
    List<BookingDetailsDTO> findByUserId(Long userId);

    void addBooking(BookingAddDTO bookingAddDTO, String username);
    void removeExpiredBookings();
}

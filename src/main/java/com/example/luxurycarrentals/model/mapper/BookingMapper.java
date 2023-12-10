package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;
import com.example.luxurycarrentals.model.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {


    @Mapping(source = "car.brand", target = "carBrand")
    @Mapping(source = "car.model", target = "carModel")
    @Mapping(source = "chauffeur.name", target = "chauffeurName")
    @Mapping(source = "chauffeur.surname", target = "chauffeurSurname")
    BookingDetailsDTO bookingToBookingDetailsDTO(Booking booking);

    @Mapping(source = "car", target = "car")
    @Mapping(source = "chauffeur", target = "chauffeur")
    Booking bookingAddDTOTOBooking(BookingAddDTO bookingAddDTO);


}

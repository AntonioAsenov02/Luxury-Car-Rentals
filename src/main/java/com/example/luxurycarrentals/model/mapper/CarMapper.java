package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "offer.perHourPrice", target = "pricePerHour")
    @Mapping(source = "offer.perDayPrice", target = "pricePerDay")
    @Mapping(source = "offer.perMonthPrice", target = "pricePerMonth")
    CarDetailsDTO carToCarDetailsDTO(Car car);
}

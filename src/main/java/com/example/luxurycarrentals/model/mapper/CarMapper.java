package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.CarAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "specifications.mileage", target = "mileage")
    @Mapping(source = "specifications.seats", target = "seats")
    @Mapping(source = "specifications.luggageCapacity", target = "luggageCapacity")
    @Mapping(source = "specifications.perHourPrice", target = "pricePerHour")
    @Mapping(source = "specifications.perDayPrice", target = "pricePerDay")
    @Mapping(source = "specifications.perMonthPrice", target = "pricePerMonth")
    CarDetailsDTO carToCarDetailsDTO(Car car);

    @Mapping(source = "mileage", target = "specifications.mileage")
    @Mapping(source = "seats", target = "specifications.seats")
    @Mapping(source = "luggageCapacity", target = "specifications.luggageCapacity")
    @Mapping(source = "perHourPrice", target = "specifications.perHourPrice")
    @Mapping(source = "perDayPrice", target = "specifications.perDayPrice")
    @Mapping(source = "perMonthPrice", target = "specifications.perMonthPrice")
    Car carAddDTOTOCar(CarAddDTO carAddDTO);
}

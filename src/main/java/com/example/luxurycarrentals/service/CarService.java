package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.CarAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    Page<CarDetailsDTO> getAllCars(Pageable pageable);

    List<CarDetailsDTO> findAllByRatingDescending();

    CarDetailsDTO findCarById(Long id);

    void addCar(CarAddDTO carAddDTO);
    List<CarDetailsDTO> getAllCars();

    void deleteCarById(Long carId);

    Car getCarById(Long carId);

    List<CarDetailsDTO> getAllCarsOrderedByBrandAndModel();

    Car findByBrandAndModel(String brand, String model);
}

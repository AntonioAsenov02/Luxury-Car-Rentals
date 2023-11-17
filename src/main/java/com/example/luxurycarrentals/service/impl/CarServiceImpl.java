package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.mapper.CarMapper;
import com.example.luxurycarrentals.repoitory.CarRepository;
import com.example.luxurycarrentals.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public Page<CarDetailsDTO> getAllOffers(Pageable pageable) {

        return carRepository.findAll(pageable)
                .map(carMapper::carToCarDetailsDTO);
    }
}

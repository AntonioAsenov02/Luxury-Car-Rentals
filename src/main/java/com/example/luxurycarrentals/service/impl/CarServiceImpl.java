package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.CarAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Specification;
import com.example.luxurycarrentals.model.mapper.CarMapper;
import com.example.luxurycarrentals.repoitory.CarRepository;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.SpecificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final SpecificationService specificationService;
    private final CarMapper carMapper;


    public CarServiceImpl(CarRepository carRepository, SpecificationService specificationService, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.specificationService = specificationService;
        this.carMapper = carMapper;
    }

    @Override
    public Page<CarDetailsDTO> getAllCars(Pageable pageable) {

        return carRepository.findAll(pageable)
                .map(carMapper::carToCarDetailsDTO);
    }

    @Override
    public List<CarDetailsDTO> findAllByRatingDescending() {

        return carRepository.findTop5ByOrderByRatingDesc()
                .stream()
                .map(carMapper::carToCarDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDetailsDTO findCarById(Long id) {

        return carRepository.findById(id)
                .map(carMapper::carToCarDetailsDTO)
                .orElse(null);
    }

    @Override
    @Transactional
    public void addCar(CarAddDTO carAddDTO) {

        Car car = carMapper.carAddDTOTOCar(carAddDTO);
        Specification specification = car.getSpecifications();

        specificationService.addSpecifications(specification);
        specification.setCar(car);
        carRepository.save(car);
    }

    @Override
    public List<CarDetailsDTO> getAllCars() {

        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteCarById(Long carId) {

        Car car = carRepository.getReferenceById(carId);
        Long specificationId = car.getSpecifications().getId();

        car.setSpecifications(null);
        carRepository.deleteById(carId);
        specificationService.deleteById(specificationId);
    }

    @Override
    public Car getCarById(Long carId) {

       return carRepository.findById(carId).orElse(null);
    }

    @Override
    public List<CarDetailsDTO> getAllCarsOrderedByBrandAndModel() {

        return carRepository.findAllByOrderByBrandAscModelAsc()
                .stream()
                .map(carMapper::carToCarDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Car findByBrandAndModel(String brand, String model) {

        return carRepository.findByBrandAndModel(brand, model);
    }
}

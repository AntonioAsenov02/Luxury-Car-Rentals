package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Specification;
import com.example.luxurycarrentals.model.enums.FuelEnum;
import com.example.luxurycarrentals.model.enums.TransmissionEnum;
import com.example.luxurycarrentals.model.mapper.CarMapper;
import com.example.luxurycarrentals.repoitory.CarRepository;
import com.example.luxurycarrentals.service.SpecificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    private CarServiceImpl serviceToStart;


    @Mock
    private CarRepository mockCarRepository;

    @Mock
    private SpecificationService mockSpecificationService;

    @Mock
    private CarMapper mockCaMapper;

    @BeforeEach
    void setUp() {

        serviceToStart = new CarServiceImpl(mockCarRepository, mockSpecificationService, mockCaMapper);
    }



    @Test
    void testFindAllByRatingDescendingWhenCarsFound() {
        // Arrange
        Car car1 = creatCar();
        Car car2 = creatSecondCar();

        List<Car> mockCars = Arrays.asList(car1, car2);

        CarDetailsDTO carDetailsDTO1 = createCarDetailsDTO();
        CarDetailsDTO carDetailsDTO2 = createSecondCarDetailsDTO();

        List<CarDetailsDTO> expectedCarDetailsDTOs = Arrays.asList(carDetailsDTO1, carDetailsDTO2);

        // Mock the behavior of carRepository
        when(mockCarRepository.findTop5ByOrderByRatingDesc()).thenReturn(mockCars);

        // Mock the behavior of carMapper
        when(mockCaMapper.carToCarDetailsDTO(car1)).thenReturn(carDetailsDTO1);
        when(mockCaMapper.carToCarDetailsDTO(car2)).thenReturn(carDetailsDTO2);

        // Act
        List<CarDetailsDTO> result = serviceToStart.findAllByRatingDescending();

        // Assert
        assertNotNull(result);
        assertEquals(expectedCarDetailsDTOs.size(), result.size());

        // Verify that carRepository method was called
        verify(mockCarRepository).findTop5ByOrderByRatingDesc();

        // Verify that carMapper method was called for each car
        verify(mockCaMapper, times(mockCars.size()))
                .carToCarDetailsDTO(any());
    }

    @Test
    void testGetAllCarsWhenCarsFound() {
        // Arrange
        Car car1 = creatCar();
        Car car2 = creatSecondCar();

        List<Car> mockCars = Arrays.asList(car1, car2);

        CarDetailsDTO carDetailsDTO1 = createCarDetailsDTO();
        CarDetailsDTO carDetailsDTO2 = createSecondCarDetailsDTO();

        List<CarDetailsDTO> expectedCarDetailsDTOs = Arrays.asList(carDetailsDTO1, carDetailsDTO2);

        // Mock the behavior of carRepository
        Page<Car> mockPage = new PageImpl<>(mockCars);
        when(mockCarRepository.findAll(any(Pageable.class))).thenReturn(mockPage);

        // Mock the behavior of carMapper
        when(mockCaMapper.carToCarDetailsDTO(car1)).thenReturn(carDetailsDTO1);
        when(mockCaMapper.carToCarDetailsDTO(car2)).thenReturn(carDetailsDTO2);

        // Act
        Page<CarDetailsDTO> result = serviceToStart.getAllCars(Pageable.unpaged());

        // Assert
        assertNotNull(result);
        assertEquals(expectedCarDetailsDTOs.size(), result.getContent().size());

        // Verify that carRepository method was called
        verify(mockCarRepository).findAll(any(Pageable.class));

        // Verify that carMapper method was called for each car
        verify(mockCaMapper, times(mockCars.size()))
                .carToCarDetailsDTO(any());
    }

    @Test
    void testFindCarByIdWhenCarFound() {
        // Arrange
        Long carId = 1L;

        Car car = creatCar();
        CarDetailsDTO expectedCarDetailsDTO = createCarDetailsDTO();

        // Mock the behavior of carRepository
        when(mockCarRepository.findById(carId)).thenReturn(Optional.of(car));

        // Mock the behavior of carMapper
        when(mockCaMapper.carToCarDetailsDTO(car)).thenReturn(expectedCarDetailsDTO);

        // Act
        CarDetailsDTO result = serviceToStart.findCarById(carId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedCarDetailsDTO, result);

        // Verify that carRepository method was called
        verify(mockCarRepository).findById(carId);

        // Verify that carMapper method was called for the found car
        verify(mockCaMapper).carToCarDetailsDTO(car);
    }

    @Test
    void testFindCarByIdWhenCarNotFound() {
        // Arrange
        Long carId = 2L;

        // Mock the behavior of carRepository
        when(mockCarRepository.findById(carId)).thenReturn(Optional.empty());

        // Act
        CarDetailsDTO result = serviceToStart.findCarById(carId);

        // Assert
        assertNull(result);

        // Verify that carRepository method was called
        verify(mockCarRepository).findById(carId);

        // Verify that carMapper method was not called since there is no car
        verifyNoInteractions(mockCaMapper);
    }

    @Test
    void testGetAllCars() {
        // Arrange
        Car car1 = creatCar();
        Car car2 = creatSecondCar();

        List<Car> mockCars = Arrays.asList(car1, car2);

        CarDetailsDTO carDetailsDTO1 = createCarDetailsDTO();
        CarDetailsDTO carDetailsDTO2 = createSecondCarDetailsDTO();

        List<CarDetailsDTO> expectedCarDetailsDTOs = Arrays.asList(carDetailsDTO1, carDetailsDTO2);

        // Mock the behavior of carRepository
        when(mockCarRepository.findAll()).thenReturn(mockCars);

        // Mock the behavior of carMapper
        when(mockCaMapper.carToCarDetailsDTO(car1)).thenReturn(carDetailsDTO1);
        when(mockCaMapper.carToCarDetailsDTO(car2)).thenReturn(carDetailsDTO2);

        // Act
        List<CarDetailsDTO> result = serviceToStart.getAllCars();

        // Assert
        assertNotNull(result);
        assertEquals(expectedCarDetailsDTOs.size(), result.size());

        // Verify that carRepository method was called
        verify(mockCarRepository).findAll();

        // Verify that carMapper method was called for each car
        verify(mockCaMapper, times(mockCars.size()))
                .carToCarDetailsDTO(any());
    }

    @Test
    void testGetAllCarsOrderedByBrandAndModel() {
        // Arrange
        Car car1 = creatCar();
        Car car2 = creatSecondCar();

        List<Car> mockCars = Arrays.asList(car2, car1); // Ordered by brand and model

        CarDetailsDTO carDetailsDTO1 = createCarDetailsDTO();
        CarDetailsDTO carDetailsDTO2 = createSecondCarDetailsDTO();

        List<CarDetailsDTO> expectedCarDetailsDTOs = Arrays.asList(carDetailsDTO2, carDetailsDTO1); // Expected order

        // Mock the behavior of carRepository
        when(mockCarRepository.findAllByOrderByBrandAscModelAsc()).thenReturn(mockCars);

        // Mock the behavior of carMapper
        when(mockCaMapper.carToCarDetailsDTO(car1)).thenReturn(carDetailsDTO1);
        when(mockCaMapper.carToCarDetailsDTO(car2)).thenReturn(carDetailsDTO2);

        // Act
        List<CarDetailsDTO> result = serviceToStart.getAllCarsOrderedByBrandAndModel();

        // Assert
        assertNotNull(result);
        assertEquals(expectedCarDetailsDTOs.size(), result.size());
        assertEquals(car1.getId(), carDetailsDTO1.getId());
        assertEquals(car1.getBrand(), carDetailsDTO1.getBrand());
        assertEquals(car1.getModel(), carDetailsDTO1.getModel());
        assertEquals(car1.getRating(), carDetailsDTO1.getRating());
        assertEquals(car1.getImageUrl(), carDetailsDTO1.getImageUrl());
        assertEquals(car1.getDescription(), carDetailsDTO1.getDescription());
        assertEquals(car1.getFuel(), carDetailsDTO1.getFuel());
        assertEquals(car1.getTransmission(), carDetailsDTO1.getTransmission());
        assertEquals(car1.getSpecifications().getMileage(), carDetailsDTO1.getMileage());
        assertEquals(car1.getSpecifications().getSeats(), carDetailsDTO1.getSeats());
        assertEquals(car1.getSpecifications().getLuggageCapacity(), carDetailsDTO1.getLuggageCapacity());
        assertEquals(car1.getSpecifications().getPerHourPrice(), carDetailsDTO1.getPricePerHour());
        assertEquals(car1.getSpecifications().getPerDayPrice(), carDetailsDTO1.getPricePerDay());
        assertEquals(car1.getSpecifications().getPerMonthPrice(), carDetailsDTO1.getPricePerMonth());

        // Verify that carRepository method was called
        verify(mockCarRepository).findAllByOrderByBrandAscModelAsc();

        // Verify that carMapper method was called for each car
        verify(mockCaMapper, times(mockCars.size()))
                .carToCarDetailsDTO(any());

        // Assert the order of results
        assertEquals(expectedCarDetailsDTOs, result);
    }

    @Test
    void testFindByBrandAndModelWhenCarFound() {
        // Arrange
        String brand = "Mercedes";
        String model = "S-class";

        Car expectedCar = creatCar();

        // Mock the behavior of carRepository
        when(mockCarRepository.findByBrandAndModel(brand, model)).thenReturn(expectedCar);

        // Act
        Car result = serviceToStart.findByBrandAndModel(brand, model);

        // Assert
        assertNotNull(result);
        assertEquals(expectedCar, result);

        // Verify that carRepository method was called
        verify(mockCarRepository).findByBrandAndModel(brand, model);
    }

    @Test
    void testFindByBrandAndModelWhenCarNotFound() {
        // Arrange
        String brand = "Ford";
        String model = "Focus";

        // Mock the behavior of carRepository
        when(mockCarRepository.findByBrandAndModel(brand, model)).thenReturn(null);

        // Act
        Car result = serviceToStart.findByBrandAndModel(brand, model);

        // Assert
        assertNull(result);

        // Verify that carRepository method was called
        verify(mockCarRepository).findByBrandAndModel(brand, model);
    }

    private CarDetailsDTO createCarDetailsDTO() {

        return new CarDetailsDTO().setId(1L)
                .setBrand("Mercedes")
                .setModel("S-class")
                .setMileage(10000)
                .setImageUrl("image/car")
                .setLuggageCapacity(4)
                .setSeats(4)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setFuel(FuelEnum.GASOLINE)
                .setRating(5)
                .setDescription("The best car")
                .setPricePerHour(BigDecimal.valueOf(100))
                .setPricePerDay(BigDecimal.valueOf(1000))
                .setPricePerMonth(BigDecimal.valueOf(7000));
    }



    private CarDetailsDTO createSecondCarDetailsDTO() {

        return new CarDetailsDTO().setId(2L)
                .setBrand("Mercedes")
                .setModel("E-class")
                .setMileage(15000)
                .setRating(4);
    }

    private Car creatCar() {

        Car car = (Car) new Car().setId(1L);

        return car.setBrand("Mercedes")
                .setModel("S-class")
                .setRating(5)
                .setReviews(new ArrayList<>())
                .setDescription("The best car")
                .setFuel(FuelEnum.GASOLINE)
                .setImageUrl("image/car")
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setYear(2022)
                .setSpecifications(new Specification()
                        .setMileage(10000)
                        .setSeats(4)
                        .setLuggageCapacity(4)
                        .setPerHourPrice(BigDecimal.valueOf(100))
                        .setPerDayPrice(BigDecimal.valueOf(1000))
                        .setPerMonthPrice(BigDecimal.valueOf(7000)));
    }

    private Car creatSecondCar() {

        Car car = (Car) new Car().setId(2L);

        return car
                .setBrand("Mercedes")
                .setModel("E-class")
                .setRating(4);
    }
}

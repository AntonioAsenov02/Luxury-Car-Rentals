package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.CarAddDTO;
import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.enums.FuelEnum;
import com.example.luxurycarrentals.model.enums.TransmissionEnum;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @MockBean
    private ReviewService reviewService;

    @Test
    @WithMockUser(username = "testUser", password = "testPassword", roles = "ADMIN")
    public void testAddCar() throws Exception {
        // When
        ResultActions resultActions = mockMvc.perform(get("/cars/add"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("add-car"));
    }



    @Test
    @WithMockUser(username = "admin@example.com", password = "12345", roles = "USER")
    public void testConfirmAddCarNotAllowed() throws Exception {
        // Given
        CarAddDTO carAddDTO = createCarAddDTO();


        // When
        ResultActions resultActions = mockMvc.perform(post("/cars/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("brand", carAddDTO.getBrand())
                .param("model", carAddDTO.getModel())
                .with(csrf()));

        // Then
        resultActions.andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetCarDetails() throws Exception {
        // Given
        Long carId = 1L;
        CarDetailsDTO carDetailsDTO = createCarDetailsDTO();
        Mockito.when(carService.findCarById(carId)).thenReturn(carDetailsDTO);

        // When
        ResultActions resultActions = mockMvc.perform(get("/cars/details/{id}", carId));

        // Then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    public void testGetCarDetailsNotFound() throws Exception {
        // Given
        Long carId = 1L;
        Mockito.when(carService.findCarById(carId)).thenReturn(null);

        // When
        ResultActions resultActions = mockMvc.perform(get("/cars/details/{id}", carId));

        // Then
        resultActions.andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUser(username = "admin@example.com", password = "12345", roles = "USER")
    public void testGetReviewsByCarId() throws Exception {
        // Given
        Long carId = 1L;
        Car car = createCar();

        CarAddDTO carAddDTO = createCarAddDTO();
        Mockito.when(carService.findCarById(1L)).thenReturn(createCarDetailsDTO());
        CarDetailsDTO carDetailsDTO = carService.findCarById(1L);

        carService.addCar(carAddDTO);

        List<ReviewInfoDTO> reviews = Collections.singletonList(createReviewInfoDTO());
        Mockito.when(reviewService.getReviewsByCarId(carId)).thenReturn(reviews);

        // When
        ResultActions resultActions = mockMvc.perform(get("/reviews/details/api/reviews/{carId}", carId)
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        resultActions.andExpect(status().is4xxClientError());
    }


    private CarAddDTO createCarAddDTO() {

        return new CarAddDTO().setId(1L)
                .setBrand("Mercedes")
                .setModel("S-class")
                .setMileage(10000)
                .setImageUrl("image/car")
                .setLuggageCapacity(4)
                .setYear(2022)
                .setSeats(4)
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setFuel(FuelEnum.GASOLINE).setDescription("The best car")
                .setPerHourPrice(BigDecimal.valueOf(100))
                .setPerDayPrice(BigDecimal.valueOf(1000))
                .setPerMonthPrice(BigDecimal.valueOf(7000));
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
                .setFuel(FuelEnum.GASOLINE).setDescription("The best car")
                .setRating(5)
                .setDescription("The best seats")
                .setPricePerHour(BigDecimal.valueOf(100))
                .setPricePerDay(BigDecimal.valueOf(1000))
                .setPricePerMonth(BigDecimal.valueOf(7000));
    }

    private ReviewInfoDTO createReviewInfoDTO() {

        return new ReviewInfoDTO().setFirstName("John")
                .setLastName("Smith")
                .setRating(5)
                .setId(1L)
                .setImageUrl("/image/url")
                .setPostedOn(LocalDate.now())
                .setText("Very nice review");
    }

    private Car createCar() {

        Car car = (Car) new Car().setId(1L);

        return car.setBrand("Mercedes")
                .setModel("S-class")
                .setRating(5)
                .setReviews(new ArrayList<>())
                .setDescription("The best car")
                .setFuel(FuelEnum.ELECTRIC)
                .setImageUrl("/image/nice")
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setYear(2022);
    }
}
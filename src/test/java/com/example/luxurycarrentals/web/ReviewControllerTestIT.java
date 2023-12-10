package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.ReviewAddDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTestIT {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @MockBean
    private CarService carService;

    @MockBean
    private Authentication authentication;

    @Test
    @WithMockUser(username = "admin@example.com", password = "testPassword", roles = "USER")
    public void testAddReview() throws Exception {
        // Given
        Long carId = 1L;
        Car car = creatCar();
        Mockito.when(carService.getCarById(carId)).thenReturn(car);

        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/reviews/add/{carId}", carId)
                .with(csrf()));

        // Then
        resultActions.andExpect(status().isOk()).
                andExpect(view().name("add-review"))
                .andExpect(model().attributeExists("car"));
    }


    private Car creatCar() {

        Car car = (Car) new Car().setId(1L);

        return car
                .setBrand("Mercedes")
                .setModel("S-class")
                .setRating(5);
    }

    private ReviewAddDTO createReviewAddDTO() {

        return new ReviewAddDTO().setId(1L)
                .setRating(5)
                .setText("It was great driving this car");
    }
}
package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.ReviewAddDTO;
import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Review;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;
import com.example.luxurycarrentals.model.mapper.ReviewMapper;
import com.example.luxurycarrentals.repoitory.ReviewRepository;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    private ReviewServiceImpl serviceToStart;

    @Mock
    private ReviewRepository mockReviewRepository;

    @Mock
    private ReviewMapper mockMapper;

    @Mock
    private CarService mockCarService;

    @Mock
    private UserService mockUserService;

    @BeforeEach
    void setUp() {

        serviceToStart = new ReviewServiceImpl(mockReviewRepository, mockMapper, mockCarService, mockUserService);
    }


    @Test
    void testGetReviewsByCarId() {
        // Arrange
        Long carId = 1L;
        List<Review> mockReviewEntities = Arrays.asList(
                createReview(),
                createReview()
        );

        // Mock the behavior of the reviewRepository
        when(mockReviewRepository.findAllByCarId(carId)).thenReturn(mockReviewEntities);

        // Mock the behavior of the reviewMapper
        when(mockMapper.reviewToReviewInfoDTO(any())).thenReturn(createReviewDTO());

        // Act
        List<ReviewInfoDTO> result = serviceToStart.getReviewsByCarId(carId);

        // Assert
        assertNotNull(result);
        assertEquals(mockReviewEntities.size(), result.size());
        assertEquals(mockReviewEntities.get(0).getUser().getFirstName(), createReviewDTO().getFirstName());
        assertEquals(mockReviewEntities.get(0).getUser().getLastName(), createReviewDTO().getLastName());
        assertEquals(mockReviewEntities.get(0).getText(), createReviewDTO().getText());
        assertEquals(mockReviewEntities.get(0).getPostedOn(), createReviewDTO().getPostedOn());
        assertEquals(mockReviewEntities.get(0).getRating(), createReviewDTO().getRating());
        assertEquals(mockReviewEntities.get(0).getUser().getImageUrl(), createReviewDTO().getImageUrl());

        // Verify that the reviewRepository method was called with the expected carId
        verify(mockReviewRepository).findAllByCarId(carId);

        // Verify that the reviewMapper method was called for each review entity
        verify(mockMapper, times(mockReviewEntities.size())).reviewToReviewInfoDTO(any());
    }

    private static Review createReview() {

        Car car = (Car) new Car().setId(1L);
        UserEntity user = new UserEntity().setEmail("admin@example.com");

        return new Review().setCar(car)
                .setUser(user
                        .setFirstName("Admin")
                        .setLastName("Adminov").setImageUrl("image/user"))
                .setText("It was a nice trip")
                .setPostedOn(LocalDate.now())
                .setRating(5);
    }

    private static ReviewInfoDTO createReviewDTO() {

        return new ReviewInfoDTO()
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setText("It was a nice trip")
                .setPostedOn(LocalDate.now())
                .setRating(5)
                .setImageUrl("image/user");
    }

}

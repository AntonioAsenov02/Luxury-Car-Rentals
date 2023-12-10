package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.ReviewAddDTO;
import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Review;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.mapper.ReviewMapper;
import com.example.luxurycarrentals.repoitory.ReviewRepository;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ReviewService;
import com.example.luxurycarrentals.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final CarService carService;
    private final UserService userService;


    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper, CarService carService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.carService = carService;
        this.userService = userService;
    }


    @Override
    public List<ReviewInfoDTO> getReviewsByCarId(Long carId) {

        return reviewRepository.findAllByCarId(carId)
                .stream()
                .map(reviewMapper::reviewToReviewInfoDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addReview(ReviewAddDTO reviewAddDTO, Long carId, String username) {

        Car car = carService.getCarById(carId);
        UserEntity user = userService.findByEmail(username);

        Review review = new Review();
        review.setRating(reviewAddDTO.getRating())
                .setText(reviewAddDTO.getText())
                .setPostedOn(LocalDate.now())
                .setCar(car)
                .setUser(user)
                .setId(reviewAddDTO.getId());

        reviewRepository.save(review);
        car.getReviews().add(review);
    }
}

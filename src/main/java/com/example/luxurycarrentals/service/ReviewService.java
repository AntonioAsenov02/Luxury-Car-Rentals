package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.ReviewAddDTO;
import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewInfoDTO> getReviewsByCarId(Long carId);

    void addReview(ReviewAddDTO reviewAddDTO, Long carId, String username);
}

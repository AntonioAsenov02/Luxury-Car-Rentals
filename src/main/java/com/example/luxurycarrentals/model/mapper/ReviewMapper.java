package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.ReviewInfoDTO;
import com.example.luxurycarrentals.model.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.imageUrl", target = "imageUrl")
    ReviewInfoDTO reviewToReviewInfoDTO(Review review);
}

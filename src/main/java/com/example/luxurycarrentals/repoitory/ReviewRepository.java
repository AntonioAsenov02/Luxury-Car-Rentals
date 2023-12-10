package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findAllByCarId(Long carId);
}

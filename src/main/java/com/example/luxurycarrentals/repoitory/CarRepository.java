package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findTop5ByOrderByRatingDesc();

    List<Car> findAllByOrderByBrandAscModelAsc();

    Car findByBrandAndModel(String brand, String model);
}

package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDetailsDTO> getAllOffers(Pageable pageable);
}

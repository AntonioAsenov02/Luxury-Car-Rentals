package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.entity.Specification;

public interface SpecificationService {

    void addSpecifications(Specification specification);

    void deleteById(Long id);
}

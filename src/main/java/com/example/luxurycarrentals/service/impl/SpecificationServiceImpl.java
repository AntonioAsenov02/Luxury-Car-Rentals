package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.entity.Specification;
import com.example.luxurycarrentals.repoitory.SpecificationRepository;
import com.example.luxurycarrentals.service.SpecificationService;
import org.springframework.stereotype.Service;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationRepository specificationRepository;


    public SpecificationServiceImpl(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }


    @Override
    public void addSpecifications(Specification specification) {

        specificationRepository.save(specification);
    }

    @Override
    public void deleteById(Long id) {

        specificationRepository.deleteById(id);
    }
}

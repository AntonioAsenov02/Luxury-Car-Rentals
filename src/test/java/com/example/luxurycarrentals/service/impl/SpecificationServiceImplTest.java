package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Specification;
import com.example.luxurycarrentals.repoitory.SpecificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SpecificationServiceImplTest {

    private SpecificationServiceImpl serviceToTest;

    @Mock
    private SpecificationRepository mockRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new SpecificationServiceImpl(mockRepository);
    }


    @Test
    void testAddSpecification() {

        Specification specification = createSpecification();

        serviceToTest.addSpecifications(specification);

        verify(mockRepository).save(specification);
        assertNotNull(mockRepository);
    }

    @Test
    void testDeleteSpecifications() {

        Specification specification = createSpecification();

        serviceToTest.addSpecifications(specification);

        Long id = specification.getId();

        serviceToTest.deleteById(id);

        verify(mockRepository).deleteById(id);
    }

    private static Specification createSpecification() {

        return new Specification()
                .setCar(new Car())
                .setMileage(10000)
                .setLuggageCapacity(2)
                .setSeats(2)
                .setPerDayPrice(new BigDecimal(25));
    }
}

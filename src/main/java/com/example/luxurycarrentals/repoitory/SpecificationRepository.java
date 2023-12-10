package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Long> {


}

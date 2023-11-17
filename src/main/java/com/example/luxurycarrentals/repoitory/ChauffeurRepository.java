package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {

}

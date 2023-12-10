package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {

    Chauffeur findByNameAndSurname(String name, String surname);

    List<Chauffeur> findAllByOrderByNameAscSurnameAsc();
}

package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Chauffeur;

import java.util.List;

public interface ChauffeurService {
    List<ChauffeurDetailsDTO> findAllChauffeurs();

    void addChauffeur(ChauffeurAddDTO chauffeurAddDTO);

    void deleteChauffeurById(Long chauffeurId);

    Chauffeur findByNameAndSurname(String name, String surname);

    List<ChauffeurDetailsDTO> getAllChauffeursByName();

    Chauffeur getChauffeurById(Long chauffeurId);
}

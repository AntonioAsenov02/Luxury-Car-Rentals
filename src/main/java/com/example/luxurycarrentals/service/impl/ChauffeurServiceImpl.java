package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import com.example.luxurycarrentals.model.mapper.ChauffeurMapper;
import com.example.luxurycarrentals.repoitory.ChauffeurRepository;
import com.example.luxurycarrentals.service.ChauffeurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChauffeurServiceImpl implements ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;
    private final ChauffeurMapper chauffeurMapper;

    public ChauffeurServiceImpl(ChauffeurRepository chauffeurRepository, ChauffeurMapper chauffeurMapper) {
        this.chauffeurRepository = chauffeurRepository;
        this.chauffeurMapper = chauffeurMapper;
    }


    @Override
    public List<ChauffeurDetailsDTO> findAllChauffeurs() {

        return chauffeurRepository.findAll()
                .stream()
                .map(chauffeurMapper::chauffeurToChauffeurDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addChauffeur(ChauffeurAddDTO chauffeurAddDTO) {

        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setName(chauffeurAddDTO.getName())
                .setSurname(chauffeurAddDTO.getSurname())
                .setGender(chauffeurAddDTO.getGender())
                .setAge(chauffeurAddDTO.getAge())
                .setImageUrl(chauffeurAddDTO.getImageUrl())
                .setPricePerHour(chauffeurAddDTO.getPricePerHour());

        chauffeurRepository.save(chauffeur);
    }

    @Override
    public void deleteChauffeurById(Long chauffeurId) {

       chauffeurRepository.deleteById(chauffeurId);
    }

    @Override
    public Chauffeur findByNameAndSurname(String name, String surname) {

        return chauffeurRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public List<ChauffeurDetailsDTO> getAllChauffeursByName() {

        return chauffeurRepository.findAllByOrderByNameAscSurnameAsc()
                .stream()
                .map(chauffeurMapper::chauffeurToChauffeurDetailsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Chauffeur getChauffeurById(Long chauffeurId) {

       return chauffeurRepository.findById(chauffeurId).orElse(null);
    }
}


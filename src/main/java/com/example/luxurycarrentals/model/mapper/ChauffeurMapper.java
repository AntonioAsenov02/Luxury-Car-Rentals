package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurDetailsDTO chauffeurToChauffeurDetailsDTO(Chauffeur chauffeur);
}

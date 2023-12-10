package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import com.example.luxurycarrentals.model.mapper.ChauffeurMapper;
import com.example.luxurycarrentals.repoitory.ChauffeurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChauffeurServiceImplTest {


    private ChauffeurServiceImpl serviceToStart;

    @Mock
    private ChauffeurRepository mockChauffeurRepository;

    @Mock
    private ChauffeurMapper mockChauffeurMapper;


    @BeforeEach
    void setUp() {

        serviceToStart = new ChauffeurServiceImpl(mockChauffeurRepository, mockChauffeurMapper);
    }


    @Test
    void testFindAllChauffeurs() {

        // Arrange
        List<Chauffeur> mockChauffeurEntities = Arrays.asList(
                creatChauffeur()
        );

        List<ChauffeurDetailsDTO> mockChauffeurDetailsDTOs = Arrays.asList(
                createChauffeurDetailsDTO()
        );

        // Mock the behavior of chauffeurRepository
        when(mockChauffeurRepository.findAll()).thenReturn(mockChauffeurEntities);

        // Mock the behavior of chauffeurMapper
        when(mockChauffeurMapper.chauffeurToChauffeurDetailsDTO(any())).thenReturn(
                mockChauffeurDetailsDTOs.get(0));

        // Act
        List<ChauffeurDetailsDTO> result = serviceToStart.findAllChauffeurs();

        // Assert
        assertNotNull(result);
        assertEquals(mockChauffeurDetailsDTOs.size(), result.size());

        // Verify that chauffeurRepository method was called
        verify(mockChauffeurRepository).findAll();

        // Verify that chauffeurMapper method was called for each chauffeur entity
        verify(mockChauffeurMapper, times(mockChauffeurEntities.size()))
                .chauffeurToChauffeurDetailsDTO(any());
    }

    @Test
    void testAddChauffeur() {
        // Arrange
        ChauffeurAddDTO chauffeurAddDTO = createChauffeurAddDTO();

        // Act
        serviceToStart.addChauffeur(chauffeurAddDTO);

        // Assert
        verify(mockChauffeurRepository).save(argThat(chauffeur ->
                chauffeur.getName().equals(chauffeurAddDTO.getName())
                        && chauffeur.getSurname().equals(chauffeurAddDTO.getSurname())
                        && chauffeur.getGender().equals(chauffeurAddDTO.getGender())
                        && chauffeur.getAge() == chauffeurAddDTO.getAge()
                        && chauffeur.getPricePerHour().equals(chauffeurAddDTO.getPricePerHour())));

    }

    @Test
    void testDeleteChauffeurById() {

        ChauffeurAddDTO chauffeurAddDTO = createChauffeurAddDTO();

        serviceToStart.addChauffeur(chauffeurAddDTO);


        assertNotNull(mockChauffeurRepository);

        serviceToStart.deleteChauffeurById(1L);

        verify(mockChauffeurRepository).deleteById(1L);
    }

    @Test
    void testFindChauffeurByNameAndSurname() {
        // Arrange
        String name = "John";
        String surname = "Smith";

        Chauffeur expectedChauffeur = creatChauffeur();

        // Mock the behavior of chauffeurRepository
        when(mockChauffeurRepository.findByNameAndSurname(name, surname)).thenReturn(expectedChauffeur);

        // Act
        Chauffeur result = serviceToStart.findByNameAndSurname(name, surname);

        // Assert
        assertNotNull(result);
        assertEquals(expectedChauffeur.getId(), result.getId());
        assertEquals(expectedChauffeur.getName(), result.getName());
        assertEquals(expectedChauffeur.getSurname(), result.getSurname());

        // Verify that chauffeurRepository method was called
        verify(mockChauffeurRepository).findByNameAndSurname(name, surname);
    }

    @Test
    void testGetAllChauffeursByName() {
        // Arrange
        Chauffeur chauffeur1 = creatChauffeur();
        Chauffeur chauffeur2 = creatSecondChauffeur();

        List<Chauffeur> mockChauffeurs = Arrays.asList(chauffeur1, chauffeur2);

        ChauffeurDetailsDTO chauffeurDetailsDTO1 = createChauffeurDetailsDTO();
        ChauffeurDetailsDTO chauffeurDetailsDTO2 = createSecondChauffeurDetailsDTO();

        List<ChauffeurDetailsDTO> expectedChauffeurDetailsDTOs = Arrays.asList(chauffeurDetailsDTO1, chauffeurDetailsDTO2);

        // Mock the behavior of chauffeurRepository
        when(mockChauffeurRepository.findAllByOrderByNameAscSurnameAsc())
                .thenReturn(List.of(mockChauffeurs.get(1), mockChauffeurs.get(0)));

        // Mock the behavior of chauffeurMapper
        when(mockChauffeurMapper.chauffeurToChauffeurDetailsDTO(chauffeur1)).thenReturn(chauffeurDetailsDTO1);
        when(mockChauffeurMapper.chauffeurToChauffeurDetailsDTO(chauffeur2)).thenReturn(chauffeurDetailsDTO2);

        // Act
        List<ChauffeurDetailsDTO> result = serviceToStart.getAllChauffeursByName();

        // Assert
        assertNotNull(result);
        assertEquals(expectedChauffeurDetailsDTOs.size(), result.size());

        // Assert the order of chauffeurs by name and surname
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Smith", result.get(0).getSurname());
        assertEquals("John", result.get(1).getName());
        assertEquals("Smith", result.get(1).getSurname());

        // Verify that chauffeurRepository method was called
        verify(mockChauffeurRepository).findAllByOrderByNameAscSurnameAsc();

        // Verify that chauffeurMapper method was called for each chauffeur
        verify(mockChauffeurMapper, times(mockChauffeurs.size()))
                .chauffeurToChauffeurDetailsDTO(any());
    }

    @Test
    void testGetChauffeurByIdWhenFound() {
        // Arrange
        Long chauffeurId = 1L;

        Chauffeur expectedChauffeur = creatChauffeur();

        // Mock the behavior of chauffeurRepository
        when(mockChauffeurRepository.findById(chauffeurId)).thenReturn(Optional.of(expectedChauffeur));

        // Act
        Chauffeur result = serviceToStart.getChauffeurById(chauffeurId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedChauffeur.getId(), result.getId());
        assertEquals(expectedChauffeur.getName(), result.getName());
        assertEquals(expectedChauffeur.getSurname(), result.getSurname());

        // Verify that chauffeurRepository method was called
        verify(mockChauffeurRepository).findById(chauffeurId);
    }

    @Test
    void testGetChauffeurByIdWhenNotFound() {
        // Arrange
        Long chauffeurId = 2L;

        // Mock the behavior of chauffeurRepository
        when(mockChauffeurRepository.findById(chauffeurId)).thenReturn(Optional.empty());

        // Act
        Chauffeur result = serviceToStart.getChauffeurById(chauffeurId);

        // Assert
        assertNull(result);

        // Verify that chauffeurRepository method was called
        verify(mockChauffeurRepository).findById(chauffeurId);
    }

    private ChauffeurDetailsDTO createChauffeurDetailsDTO() {

        return new ChauffeurDetailsDTO().setId(1L)
                .setName("John")
                .setSurname("Smith")
                .setGender("male")
                .setAge(30)
                .setPricePerHour(BigDecimal.valueOf(30));
    }

    private ChauffeurDetailsDTO createSecondChauffeurDetailsDTO() {

        return new ChauffeurDetailsDTO().setId(2L)
                .setName("Alice")
                .setSurname("Smith")
                .setGender("female")
                .setAge(30)
                .setPricePerHour(BigDecimal.valueOf(30));
    }

    private Chauffeur creatChauffeur() {

        Chauffeur chauffeur = (Chauffeur) new Chauffeur().setId(1L);

        return chauffeur.setName("John")
                .setSurname("Smith")
                .setGender("male")
                .setAge(30)
                .setPricePerHour(BigDecimal.valueOf(30));
    }

    private Chauffeur creatSecondChauffeur() {

        Chauffeur chauffeur = (Chauffeur) new Chauffeur().setId(2L);

        return chauffeur.setName("Alice")
                .setSurname("Smith")
                .setGender("female")
                .setAge(30)
                .setPricePerHour(BigDecimal.valueOf(30));
    }

    private ChauffeurAddDTO createChauffeurAddDTO() {

        return new ChauffeurAddDTO()
                .setName("John")
                .setSurname("Smith")
                .setGender("male")
                .setAge(30)
                .setPricePerHour(BigDecimal.valueOf(30));
    }
}

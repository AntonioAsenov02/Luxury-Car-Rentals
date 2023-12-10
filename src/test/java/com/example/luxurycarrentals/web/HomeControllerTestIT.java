package com.example.luxurycarrentals.web;


import com.example.luxurycarrentals.model.dto.CarDetailsDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ChauffeurService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @MockBean
    private ChauffeurService chauffeurService;

    @Test
    @WithMockUser(username = "testUser", password = "testPassword", roles = "USER")
    public void testHomeAuthenticatedUser() throws Exception {
        // Given
        Authentication authentication = Mockito.mock(Authentication.class);

        // Mock data for the home method
        List<CarDetailsDTO> topFiveBestRated = Collections.emptyList();
        List<CarDetailsDTO> carBrands = Collections.emptyList();
        List<ChauffeurDetailsDTO> chauffeurs = Collections.emptyList();

        Mockito.when(carService.findAllByRatingDescending()).thenReturn(topFiveBestRated);
        Mockito.when(carService.getAllCarsOrderedByBrandAndModel()).thenReturn(carBrands);
        Mockito.when(chauffeurService.getAllChauffeursByName()).thenReturn(chauffeurs);

        // When
        ResultActions resultActions = mockMvc.perform(get("/")
                .flashAttr("authentication", authentication));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("bestRated", topFiveBestRated))
                .andExpect(model().attribute("cars", carBrands))
                .andExpect(model().attribute("chauffeurs", chauffeurs));
    }

    @Test
    public void testHomeUnauthenticatedUser() throws Exception {
        // Given
        Authentication authentication = null; // Unauthenticated user

        // Mock data for the home method
        List<CarDetailsDTO> topFiveBestRated = Collections.emptyList();
        List<CarDetailsDTO> carBrands = Collections.emptyList();
        List<ChauffeurDetailsDTO> chauffeurs = Collections.emptyList();

        Mockito.when(carService.findAllByRatingDescending()).thenReturn(topFiveBestRated);
        Mockito.when(carService.getAllCarsOrderedByBrandAndModel()).thenReturn(carBrands);
        Mockito.when(chauffeurService.getAllChauffeursByName()).thenReturn(chauffeurs);

        // When
        ResultActions resultActions = mockMvc.perform(get("/"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("bestRated", topFiveBestRated))
                .andExpect(model().attribute("cars", carBrands))
                .andExpect(model().attribute("chauffeurs", chauffeurs));
    }
}
package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.ChauffeurAddDTO;
import com.example.luxurycarrentals.model.dto.ChauffeurDetailsDTO;
import com.example.luxurycarrentals.service.ChauffeurService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ChauffeurControllerTestIT {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChauffeurService chauffeurService;

    @Test
    public void testAllChauffeurs() throws Exception {
        // Given
        List<ChauffeurDetailsDTO> allChauffeurs = Collections.emptyList();
        Mockito.when(chauffeurService.findAllChauffeurs()).thenReturn(allChauffeurs);

        // When
        ResultActions resultActions = mockMvc.perform(get("/chauffeurs/all"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("chauffeur"))
                .andExpect(model().attribute("allChauffeurs", allChauffeurs));
    }

    @Test
    public void testAddChauffeur() throws Exception {
        // When
        ResultActions resultActions = mockMvc.perform(get("/chauffeurs/add"));

        // Then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "testUser", password = "testPassword", roles = "ADMIN")
    public void testConfirmAddChauffeur() throws Exception {
        // Given
        ChauffeurAddDTO chauffeurAddDTO = new ChauffeurAddDTO();
        chauffeurAddDTO.setName("Test Chauffeur");


        mockMvc.perform(
                MockMvcRequestBuilders.post("/chauffeurs/add")
                        .param("name", chauffeurAddDTO.getName())
                        .with(csrf())
        ).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("add"));
    }

}
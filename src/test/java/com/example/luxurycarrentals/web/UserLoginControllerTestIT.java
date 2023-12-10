package com.example.luxurycarrentals.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginControllerTestIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testLogin() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/login")
                        .param("email", "admin@example.com")
                        .param("password", "12345")
                        .with(csrf())
        ).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "testUser", password = "testPassword", roles = "USER")
    public void testLogout() throws Exception {
        // When
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/users/logout"));

        // Then
        resultActions.andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    void testLoginError() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/login-error")
                        .param("email", "a")
                        .param("password", "12345")
                        .with(csrf())
        ).andExpect(status().isOk())
                .andExpect(view().name("auth-login"));
    }
}
package com.example.luxurycarrentals.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserRegisterControllerTestIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testRegistration() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("firstName", "Steve")
                        .param("lastName", "Franky")
                        .param("email", "franky@example.com")
                        .param("password", "12345")
                        .param("confirmPassword", "12345")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection());
    }

    @Test
    void tetRegistrationWrongConfirmationPassword() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("firstName", "Steve")
                        .param("lastName", "Franky")
                        .param("email", "franky@example.com")
                        .param("password", "12345")
                        .param("confirmPassword", "1234")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:register"));
    }
}
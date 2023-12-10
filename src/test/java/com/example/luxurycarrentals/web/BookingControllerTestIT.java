package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.BookingAddDTO;
import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import com.example.luxurycarrentals.repoitory.BookingRepository;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.CarService;
import com.example.luxurycarrentals.service.ChauffeurService;
import com.example.luxurycarrentals.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookingControllerTestIT {

    @Autowired
    private MockMvc mockMvc;



    @Test
    @WithMockUser(username = "testUser", password = "password", roles = "USER")
    public void testAddBookingUserNotFound() throws Exception {
        // Given
        BookingAddDTO bookingAddDTO = creatBookingAddDTO();

        // When
        ResultActions resultActions = mockMvc.perform(post("/bookings/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("bookingAddDTO", bookingAddDTO));

        // Then
        resultActions.andExpect(status().is4xxClientError());

    }


    private BookingAddDTO creatBookingAddDTO() {

        return new BookingAddDTO()
                .setId(1L)
                .setCar(new Car()
                        .setBrand("Mercedes")
                        .setBrand("S-class"))
                .setChauffeur(new Chauffeur()
                        .setName("Frank")
                        .setSurname("Martin"))
                .setPickUpDate(LocalDateTime.of(2023, Month.DECEMBER, 14, 12,0))
                .setDropOffDate(LocalDateTime.of(2023, Month.DECEMBER, 15, 12,0))
                .setPickUpLocation("Sofia")
                .setDropOffLocation("Sofia");
    }
}
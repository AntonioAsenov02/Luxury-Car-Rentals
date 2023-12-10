package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.dto.BookingDetailsDTO;
import com.example.luxurycarrentals.model.dto.ProfileDetailsDTO;
import com.example.luxurycarrentals.service.BookingService;
import com.example.luxurycarrentals.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private BookingService bookingService;

    @Test
    @WithMockUser(username = "testUser", password = "testPassword", roles = "USER")
    public void testProfile() throws Exception {
        // Given
        ProfileDetailsDTO mockUserProfile = new ProfileDetailsDTO();
        mockUserProfile.setId(1L);
        mockUserProfile.setEmail("testUser@example.com");

        List<BookingDetailsDTO> mockBookings = List.of(createBooingDetailsDTO());

        Mockito.when(userService.getByEmail(Mockito.any(), Mockito.anyString())).thenReturn(mockUserProfile);
        Mockito.when(bookingService.findByUserId(Mockito.anyLong())).thenReturn(mockBookings);

        // When
        ResultActions resultActions = mockMvc.perform(get("/profile"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(model().attribute("user", mockUserProfile))
                .andExpect(model().attribute("bookings", mockBookings));
    }

    private BookingDetailsDTO createBooingDetailsDTO() {

        return new BookingDetailsDTO().setBookingNumber("1231232").setDropOffDate(LocalDateTime.now())
                .setPickUpDate(LocalDateTime.now());
    }
}
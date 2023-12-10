package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.ProfileDetailsDTO;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;
import com.example.luxurycarrentals.model.mapper.UserMapper;
import com.example.luxurycarrentals.repoitory.UserRepository;
import com.example.luxurycarrentals.service.UserRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private UserServiceImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private UserMapper mockUserMapper;

    @Mock
    private PasswordEncoder mockPasswordEncoder;

    @Mock
    private UserDetailsService mockUserDetailsService;

    @Mock
    private UserRoleService mockUserRoleService;


    @BeforeEach
    void setUp() {
        serviceToTest = new UserServiceImpl(mockUserRepository,mockUserMapper,
                mockPasswordEncoder,mockUserDetailsService,mockUserRoleService);
    }

    @Test
    void testFindByEmailExistingUser() {
        // Arrange
        String email = "test@example.com";
        UserEntity expectedUser = new UserEntity(); // Create a dummy UserEntity for testing

        when(mockUserRepository.findByEmail(email)).thenReturn(Optional.of(expectedUser));

        // Act
        UserEntity result = serviceToTest.findByEmail(email);

        // Assert
        assertEquals(expectedUser, result);
    }

    @Test
    void testFindByEmailNotFound() {
        // Arrange
        String email = "nonexistent@example.com";

        when(mockUserRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        UserEntity result = serviceToTest.findByEmail(email);

        // Assert
        assertNull(result);
    }

    @Test
    void testGetByEmail_UserExists() {
        // Arrange
        ProfileDetailsDTO profileDetailsDTO = new ProfileDetailsDTO();

        UserEntity testUserEntity = createTestUser();
        when(mockUserRepository.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        // Act
        ProfileDetailsDTO result = serviceToTest.getByEmail(profileDetailsDTO, testUserEntity.getEmail());

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Smith", result.getLastName());
        assertEquals(testUserEntity.getEmail(), result.getEmail());
    }

    @Test
    void testGetByEmail_UserNotFound() {
        // Arrange
        String email = "nonexistent@example.com";
        ProfileDetailsDTO profileDetailsDTO = new ProfileDetailsDTO();

        when(mockUserRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        ProfileDetailsDTO result = serviceToTest.getByEmail(profileDetailsDTO, email);

        // Assert
        assertNull(result);
    }

    private static UserEntity createTestUser() {
        return new UserEntity()
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("admin@example.com")
                .setPassword("12345")
                .setUserRoles(List.of(
                        new UserRole().setUserRole(UserRoleEnum.ADMIN),
                        new UserRole().setUserRole(UserRoleEnum.USER)
                ));
    }
}

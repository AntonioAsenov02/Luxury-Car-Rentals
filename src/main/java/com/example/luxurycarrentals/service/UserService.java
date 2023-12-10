package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.ProfileDetailsDTO;
import com.example.luxurycarrentals.model.dto.UserRegisterDTO;
import com.example.luxurycarrentals.model.entity.UserEntity;

import java.util.Locale;

public interface UserService {
    void registerAndLogin(UserRegisterDTO userModel);
    UserEntity findByEmail(String username);

    ProfileDetailsDTO getByEmail(ProfileDetailsDTO profileDetailsDTO ,String email);
}

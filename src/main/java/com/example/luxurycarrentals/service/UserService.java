package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.dto.UserRegisterDTO;

import java.util.Locale;

public interface UserService {
    void registerAndLogin(UserRegisterDTO userModel);
}

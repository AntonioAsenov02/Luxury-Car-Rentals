package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;
import com.example.luxurycarrentals.repoitory.UserRoleRepository;
import com.example.luxurycarrentals.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;


    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void initRoles() {

        if (userRoleRepository.count() != 0) {
            return;
        }

        Arrays.stream(UserRoleEnum.values())
                .forEach(userRoleEnum -> {
                    UserRole userRole = new UserRole();
                    userRole.setUserRole(userRoleEnum);

                    userRoleRepository.save(userRole);
                });
    }

    @Override
    public UserRole findByUserRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findByUserRole(userRoleEnum);
    }
}

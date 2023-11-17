package com.example.luxurycarrentals.service;

import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;

public interface UserRoleService {
    void initRoles();
    UserRole findByUserRole(UserRoleEnum userRoleEnum);

}

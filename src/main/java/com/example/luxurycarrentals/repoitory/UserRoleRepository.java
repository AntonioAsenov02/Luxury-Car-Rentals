package com.example.luxurycarrentals.repoitory;

import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByUserRole(UserRoleEnum userRoleEnum);
}

package com.example.luxurycarrentals.init;

import com.example.luxurycarrentals.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initRoles implements CommandLineRunner {

    private final UserRoleService userRoleService;


    public initRoles(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args) throws Exception {

        userRoleService.initRoles();
    }
}

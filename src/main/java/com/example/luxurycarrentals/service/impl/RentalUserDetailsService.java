package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.entity.UserRole;
import com.example.luxurycarrentals.repoitory.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class RentalUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public RentalUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository
                .findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getUserRoles().stream().map(this::mapRole).toList())
                .build();
    }

    private GrantedAuthority mapRole(UserRole userRoleEntity) {

        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getUserRole().name());
    }
}
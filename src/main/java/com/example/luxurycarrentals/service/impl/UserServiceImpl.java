package com.example.luxurycarrentals.service.impl;

import com.example.luxurycarrentals.model.dto.UserRegisterDTO;
import com.example.luxurycarrentals.model.entity.UserEntity;
import com.example.luxurycarrentals.model.enums.UserRoleEnum;
import com.example.luxurycarrentals.model.mapper.UserMapper;
import com.example.luxurycarrentals.repoitory.UserRepository;
import com.example.luxurycarrentals.service.UserRoleService;
import com.example.luxurycarrentals.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final UserRoleService userRoleService;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userRoleService = userRoleService;
    }


    @Override
    public void registerAndLogin(UserRegisterDTO userModel) {

        UserEntity user = userMapper.userDtoToUser(userModel);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.count() == 0) {
            user.getUserRoles().add(userRoleService.findByUserRole(UserRoleEnum.ADMIN));
        }else {
         user.getUserRoles().add(userRoleService.findByUserRole(UserRoleEnum.USER));
        }

        userRepository.save(user);

        login(user);
    }

    public void login(UserEntity userEntity) {

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}

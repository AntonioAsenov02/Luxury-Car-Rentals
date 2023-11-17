package com.example.luxurycarrentals.model.mapper;

import com.example.luxurycarrentals.model.dto.UserRegisterDTO;
import com.example.luxurycarrentals.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userDtoToUser(UserRegisterDTO userRegisterDTO);
}
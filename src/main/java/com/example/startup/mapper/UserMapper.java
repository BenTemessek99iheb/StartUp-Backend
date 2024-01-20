package com.example.startup.mapper;

import com.example.startup.dto.UserDTO;
import com.example.startup.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}

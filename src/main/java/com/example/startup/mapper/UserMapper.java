package com.example.startup.mapper;

import com.example.startup.dto.UserDTO;
import com.example.startup.entities.User;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper extends GenericMapper<User,UserDTO> {

}

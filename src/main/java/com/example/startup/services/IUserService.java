package com.example.startup.services;

import com.example.startup.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserDTO addUser(UserDTO u);

    void removeUser(UUID id);

    Page<UserDTO> retrieveAllUsers(Pageable pageable);
    public List<UserDTO> retrieveUsers();

    UserDTO updateUser(UserDTO userDto);


    UserDTO retrieveUserById(UUID id);

    Long countUsers();
}

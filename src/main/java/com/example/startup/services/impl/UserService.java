package com.example.startup.services.impl;

import com.example.startup.dto.UserDTO;
import com.example.startup.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
    @Override
    public UserDTO addUser(UserDTO u) {
        return null;
    }

    @Override
    public void removeUser(UUID id) {

    }

    @Override
    public Page<UserDTO> retrieveAllUsers(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserDTO> retrieveUsers() {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDTO retrieveUserById(UUID id) {
        return null;
    }

    @Override
    public Long countUsers() {
        return null;
    }
}

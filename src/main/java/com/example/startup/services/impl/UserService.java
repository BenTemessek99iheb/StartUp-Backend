package com.example.startup.services.impl;

import com.example.startup.dto.UserDTO;
import com.example.startup.entities.User;
import com.example.startup.mapper.UserMapper;
import com.example.startup.repositories.UserRepo;
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

    private final UserRepo userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO addUser(UserDTO userDto) {
        User user = userRepository.save(userMapper.toModel(userDto));
        return userMapper.toDto(user);
    }

    @Override
    public void removeUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserDTO> retrieveAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> retrieveUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDto.getId()));

        // Update the user fields with values from the UserDTO
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateNaissance(userDto.getDateNaissance());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword()); // TODO: Hash the password
        user.setRole(userDto.getRole());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());

        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser);
    }

    @Override
    public UserDTO retrieveUserById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Long countUsers() {
        return userRepository.count();
    }
}

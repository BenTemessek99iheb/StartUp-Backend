package com.example.startup.controllers;

import com.example.startup.dto.UserDTO;
import com.example.startup.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
        UserDTO createdUser = userService.addUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable UUID id) {
        userService.removeUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> retrieveAllUsers(Pageable pageable) {
        Page<UserDTO> users = userService.retrieveAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> retrieveUsers() {
        List<UserDTO> users = userService.retrieveUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody UserDTO userDto) {
        UserDTO updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> retrieveUserById(@PathVariable UUID id) {
        UserDTO user = userService.retrieveUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        Long count = userService.countUsers();
        return ResponseEntity.ok(count);
    }
}

package com.spring.boot.springtasklec11.controller;

import com.spring.boot.springtasklec11.dto.UserRequestDTO;
import com.spring.boot.springtasklec11.dto.UserResponseDTO;
import com.spring.boot.springtasklec11.dto.UserWithPostsDto;
import com.spring.boot.springtasklec11.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST http://localhost:8086/api/users
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.CREATED);
    }

    // GET http://localhost:8086/api/users
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // GET http://localhost:8086/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // PUT http://localhost:8086/api/users/1
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userRequestDTO));
    }

    // DELETE http://localhost:8086/api/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // GET http://localhost:8086/api/users/with-posts
    @GetMapping("/with-posts")
    public ResponseEntity<List<UserWithPostsDto>> getAllUsersWithPosts() {
        return ResponseEntity.ok(userService.getAllUsersWithPosts());
    }

    // GET http://localhost:8086/api/users/1/with-posts
    @GetMapping("/{id}/with-posts")
    public ResponseEntity<UserWithPostsDto> getUserWithPostsById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserWithPostsById(id));
    }
}
package com.spring.boot.springtasklec11.service;

import com.spring.boot.springtasklec11.dto.UserRequestDTO;
import com.spring.boot.springtasklec11.dto.UserResponseDTO;
import com.spring.boot.springtasklec11.dto.UserWithPostsDto;
import com.spring.boot.springtasklec11.model.User;

import java.util.List;

public interface UserService {

   UserResponseDTO createUser (UserRequestDTO userRequestDTO);
   UserResponseDTO  getUserById(Long id);
   List<UserResponseDTO> getAllUsers();
   UserResponseDTO   updateUser(Long id,UserRequestDTO userRequestDTO);
   void deleteUser(Long id);
   List<UserWithPostsDto>  getAllUsersWithPosts();
    UserWithPostsDto getUserWithPostsById(Long id);

}

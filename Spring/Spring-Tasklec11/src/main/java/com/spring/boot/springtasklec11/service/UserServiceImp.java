package com.spring.boot.springtasklec11.service;

import com.spring.boot.springtasklec11.dto.UserRequestDTO;
import com.spring.boot.springtasklec11.dto.UserResponseDTO;
import com.spring.boot.springtasklec11.dto.UserWithPostsDto;
import com.spring.boot.springtasklec11.mapper.UserMapper;
import com.spring.boot.springtasklec11.model.Post;
import com.spring.boot.springtasklec11.model.User;
import com.spring.boot.springtasklec11.repo.PostRepo;
import com.spring.boot.springtasklec11.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final UserMapper userMapper;

    public UserServiceImp(UserRepo userRepo, PostRepo postRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user=userMapper.toUserRequestEntity(userRequestDTO);
        if (user.getId()!=null){
            throw new RuntimeException("New user should not have an ID");
        }
        return userMapper.toUserResponseDTO(userRepo.save(user));
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userMapper.toUserResponseDTO(userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found with id "+id)));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toUserResponseDTOList(userRepo.findAll());

    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setName(userRequestDTO.getName());
        existingUser.setAge(userRequestDTO.getAge());
        existingUser.setPassword(userRequestDTO.getPassword());

        return userMapper.toUserResponseDTO(userRepo.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {

        User existingUser=userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found "));
        userRepo.delete(existingUser);
    }

    @Override
    public List<UserWithPostsDto> getAllUsersWithPosts() {
        return userMapper.toUserWithPostsDtoList(userRepo.findAllWithPosts());
    }

    @Override
    public UserWithPostsDto getUserWithPostsById(Long id) {
        return userMapper.toUserWithPostsDto(userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found ")));
    }
}

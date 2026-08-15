package com.spring.boot.springtasklec11.service;

import com.spring.boot.springtasklec11.dto.PostRequestDTO;
import com.spring.boot.springtasklec11.dto.PostResponseDTO;
import com.spring.boot.springtasklec11.dto.PostWithUsersDto;

import java.util.List;

public interface PostService {

  PostResponseDTO createPost(PostRequestDTO postRequestDTO);
  PostResponseDTO getPostById(Long id);
  List<PostResponseDTO> getAllPosts();
  PostResponseDTO updatePost(Long id , PostRequestDTO postRequestDTO);
  void deletePost(Long id);
  List<PostResponseDTO> getPostsByUserId(List<Long> usersId);
  List<PostWithUsersDto> getAllPostsWithUsers();
  PostWithUsersDto getPostWithUserById(Long id);
}

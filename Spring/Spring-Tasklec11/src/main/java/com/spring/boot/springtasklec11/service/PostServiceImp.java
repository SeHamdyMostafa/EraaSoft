package com.spring.boot.springtasklec11.service;

import com.spring.boot.springtasklec11.dto.PostRequestDTO;
import com.spring.boot.springtasklec11.dto.PostResponseDTO;
import com.spring.boot.springtasklec11.dto.PostWithUsersDto;
import com.spring.boot.springtasklec11.mapper.PostMapper;
import com.spring.boot.springtasklec11.model.Post;
import com.spring.boot.springtasklec11.model.User;
import com.spring.boot.springtasklec11.repo.PostRepo;
import com.spring.boot.springtasklec11.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private final PostRepo postRepo;
    private final PostMapper postMapper;
    private final UserRepo userRepo;

    public PostServiceImp(PostRepo postRepo,PostMapper postMapper ,UserRepo userRepo) {
        this.postRepo = postRepo;
        this.postMapper=postMapper;
        this.userRepo=userRepo;
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        Post post=postMapper.toPostEntity(postRequestDTO);
        if(post.getId()!=null){
            throw new RuntimeException("new post should not have ID");
        }

        if (postRequestDTO.getUserId() != null) {
            User user = userRepo.findById(postRequestDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + postRequestDTO.getUserId()));
            post.setUser(user);
        }

        return postMapper.toPostResponseDTO(postRepo.save(post));
    }

    @Override
    public PostResponseDTO getPostById(Long id) {
        return postMapper.toPostResponseDTO(postRepo.findById(id).orElseThrow(()->new RuntimeException("Post not found with id: " + id)));
    }

    @Override
    public List<PostResponseDTO> getAllPosts() {
        return postMapper.toPostResponseDTOList(postRepo.findAll());
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO) {
        Post existingPost = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        existingPost.setText(postRequestDTO.getText());
        existingPost.setImagePath(postRequestDTO.getImagePath());

        if (postRequestDTO.getUserId() != null) {
            User user = userRepo.findById(postRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + postRequestDTO.getUserId()));
            existingPost.setUser(user);
        }

        return postMapper.toPostResponseDTO(postRepo.save(existingPost));
    }

    @Override
    public void deletePost(Long id) {

        Post existingPost = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        postRepo.delete(existingPost);

    }

    @Override
    public List<PostResponseDTO> getPostsByUserId(List<Long> usersId) {

        return postMapper.toPostResponseDTOList(postRepo.findByUserIdIn(usersId));
        
    }

    @Override
    public List<PostWithUsersDto> getAllPostsWithUsers() {
        return postMapper.toPostWithUsersDtoList(postRepo.findAllWithUser());
    }

    @Override
    public PostWithUsersDto getPostWithUserById(Long id) {
        return postMapper.toPostWithUsersDto(postRepo.findById(id).orElseThrow(()->new RuntimeException("Post not found")));
    }
}

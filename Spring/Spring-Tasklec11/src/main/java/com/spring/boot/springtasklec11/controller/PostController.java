package com.spring.boot.springtasklec11.controller;

import com.spring.boot.springtasklec11.dto.PostRequestDTO;
import com.spring.boot.springtasklec11.dto.PostResponseDTO;
import com.spring.boot.springtasklec11.dto.PostWithUsersDto;
import com.spring.boot.springtasklec11.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // POST http://localhost:8086/api/posts
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        return new ResponseEntity<>(postService.createPost(postRequestDTO), HttpStatus.CREATED);
    }

    // GET http://localhost:8086/api/posts
    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // GET http://localhost:8086/api/posts/1
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // PUT http://localhost:8086/api/posts/1
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long id, @Valid @RequestBody PostRequestDTO postRequestDTO) {
        return ResponseEntity.ok(postService.updatePost(id, postRequestDTO));
    }

    // DELETE http://localhost:8086/api/posts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // GET http://localhost:8086/api/posts/by-users?userIds=1,2,3
    @GetMapping("/by-users")
    public ResponseEntity<List<PostResponseDTO>> getPostsByUserIds(@RequestParam List<Long> userIds) {
        return ResponseEntity.ok(postService.getPostsByUserId(userIds));
    }

    // GET http://localhost:8086/api/posts/with-users
    @GetMapping("/with-users")
    public ResponseEntity<List<PostWithUsersDto>> getAllPostsWithUsers() {
        return ResponseEntity.ok(postService.getAllPostsWithUsers());
    }

    // GET http://localhost:8086/api/posts/1/with-user
    @GetMapping("/{id}/with-user")
    public ResponseEntity<PostWithUsersDto> getPostWithUserById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostWithUserById(id));
    }
}
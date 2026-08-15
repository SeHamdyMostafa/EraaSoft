package com.spring.boot.springtasklec11.mapper;

import com.spring.boot.springtasklec11.dto.PostRequestDTO;
import com.spring.boot.springtasklec11.dto.PostResponseDTO;
import com.spring.boot.springtasklec11.dto.PostWithUsersDto;
import com.spring.boot.springtasklec11.model.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPostEntity(PostRequestDTO postRequestDTO);
    PostResponseDTO toPostResponseDTO(Post post);
    List<PostResponseDTO> toPostResponseDTOList(List<Post> postList);
    List<PostWithUsersDto> toPostWithUsersDtoList(List<Post> postList);
    PostWithUsersDto toPostWithUsersDto(Post post);

}

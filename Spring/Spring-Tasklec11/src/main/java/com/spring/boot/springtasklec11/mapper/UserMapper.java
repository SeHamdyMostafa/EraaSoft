package com.spring.boot.springtasklec11.mapper;

import com.spring.boot.springtasklec11.dto.UserRequestDTO;
import com.spring.boot.springtasklec11.dto.UserResponseDTO;
import com.spring.boot.springtasklec11.dto.UserWithPostsDto;
import com.spring.boot.springtasklec11.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserRequestEntity(UserRequestDTO userRequestDTO);
    UserResponseDTO toUserResponseDTO(User user);
    List<UserResponseDTO> toUserResponseDTOList(List<User> users);
    UserWithPostsDto toUserWithPostsDto(User users);
    List<UserWithPostsDto> toUserWithPostsDtoList(List<User> users);

}

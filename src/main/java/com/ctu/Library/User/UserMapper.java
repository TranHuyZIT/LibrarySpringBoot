package com.ctu.Library.User;


import com.ctu.Library.User.DTO.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userName", expression = "java(user.getUsername())")
    UserResponseDTO modelTODTO(User user);


}

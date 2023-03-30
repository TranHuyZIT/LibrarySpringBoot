package com.ctu.Library.User.Mapper;

import com.ctu.Library.User.DTO.UserListResponseDTO;
import com.ctu.Library.User.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserListResponseMapper {
    UserListResponseDTO modelToDTO(User user);
    Set<UserListResponseDTO> modelsTODTOS(List<User> users);
}

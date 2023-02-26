package com.kruger.challenge.dto.user;

import com.kruger.challenge.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User model);

    User toModel(UserDto dto);
}

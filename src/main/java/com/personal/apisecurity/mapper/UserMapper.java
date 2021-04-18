package com.personal.apisecurity.mapper;

import org.mapstruct.Mapper;

import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toEntity(UserEntityDTO dto);
	
	UserEntityDTO toDto(User entity);
}

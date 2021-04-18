package com.personal.apisecurity.mapper;

import org.mapstruct.Mapper;

import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toEntity(UserEntityDTO dto);
	
	UserEntityDTO toDto(User entity);
	
	UserViewDTO toViewDto(User entity);
}

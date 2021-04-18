package com.personal.apisecurity.mapper;

import org.mapstruct.Mapper;

import com.personal.apisecurity.model.Profile;
import com.personal.apisecurity.model.dto.ProfileEntityDTO;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	Profile toEntity(ProfileEntityDTO dto);
	
	ProfileEntityDTO toDto(Profile entity);
}

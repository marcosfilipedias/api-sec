package com.personal.apisecurity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "idProfile", target = "profile.id")
	User toEntity(UserEntityDTO dto);
	
	@Mapping(source = "profile.id", target = "idProfile")
	UserEntityDTO toDto(User entity);
	
	@Mapping(source = "profile.id", target = "idProfile")
	UserViewDTO toViewDto(User entity);	
	
	/*@Mapping(source = "idSegmento", target = "segmento.id")
	@Mapping(source = "idShopping", target = "shopping.id")
	Loja toEntity(LojaEntidadeDTO lojaEntidadeDTO);
	
	@Mapping(source = "segmento.id", target = "idSegmento")
	@Mapping(source = "shopping.id", target = "idShopping")
	CadastroLojaDTO toDTO(Loja loja);*/
}

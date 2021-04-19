package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;

public interface UserService {

	UserViewDTO saveUser(UserEntityDTO user);
		
	Boolean deleteUser(Integer id);
	
	UserViewDTO getUserById(Integer id);
	
	List<UserViewDTO> getAllUsers();
	
	Integer buscarIdUsuarioToken(String login);
}

package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;

public interface UserService {

	UserViewDTO saveUser(UserEntityDTO user);
		
	Boolean deleteUser(Long id);
	
	UserViewDTO getUserById(Long id);
	
	List<UserViewDTO> getAllUsers();
		
	String getProfileByLogin(String login);

	Long getUserIdByLogin(String login);
}

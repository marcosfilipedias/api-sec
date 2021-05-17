package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;

public interface UserService {

	UserViewDTO saveUser(UserEntityDTO user);
		
	Boolean deleteUser(Long id);
	
	UserViewDTO getUserById(Long id);
	
	List<UserViewDTO> getAllUsers();
		
	UserEntityDTO getUserByEmail(String email) throws InvalidLoginException;
}

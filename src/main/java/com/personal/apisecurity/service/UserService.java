package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.model.User;
import com.personal.apisecurity.model.dto.UserViewDTO;

public interface UserService {

	UserViewDTO createUser(User user);
	
	UserViewDTO updateUser(User user);
	
	Boolean deleteUser(User user);
	
	UserViewDTO getUserById(Integer id);
	
	List<UserViewDTO> getAllUsers();
}

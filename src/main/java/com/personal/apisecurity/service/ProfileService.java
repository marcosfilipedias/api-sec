package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.model.dto.ProfileEntityDTO;

public interface ProfileService {

	ProfileEntityDTO saveUser(ProfileEntityDTO profile);
		
	Boolean deleteUser(Integer id);
	
	ProfileEntityDTO getUserById(Integer id);
	
	List<ProfileEntityDTO> getAllUsers();
}

package com.personal.apisecurity.service;

import java.util.List;

import com.personal.apisecurity.model.dto.ProfileEntityDTO;

public interface ProfileService {

	ProfileEntityDTO saveProfile(ProfileEntityDTO profile);
		
	Boolean deleteProfile(Integer id);
	
	ProfileEntityDTO getProfileById(Integer id);
	
	List<ProfileEntityDTO> getAllProfiles();
}

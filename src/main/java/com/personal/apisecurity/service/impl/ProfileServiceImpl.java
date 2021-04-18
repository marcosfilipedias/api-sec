package com.personal.apisecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.personal.apisecurity.mapper.ProfileMapper;
import com.personal.apisecurity.model.Profile;
import com.personal.apisecurity.model.dto.ProfileEntityDTO;
import com.personal.apisecurity.repository.ProfileRepository;
import com.personal.apisecurity.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	private ProfileRepository profileRepository;
	private ProfileMapper profileMapper;

	public ProfileServiceImpl(ProfileRepository profileRepository, ProfileMapper profileMapper) {
		super();
		this.profileRepository = profileRepository;
		this.profileMapper = profileMapper;
	}

	@Override
	public ProfileEntityDTO saveProfile(ProfileEntityDTO profile) {
		Profile savedProfile = profileRepository.saveAndFlush(profileMapper.toEntity(profile));
		return profileMapper.toDto(savedProfile);
	}

	@Override
	public Boolean deleteProfile(Integer id) {
		profileRepository.deleteById(id);
		return getProfileById(id) == null;
	}

	@Override
	public ProfileEntityDTO getProfileById(Integer id) {
		return profileMapper.toDto(profileRepository.findById(id).get());
	}

	@Override
	public List<ProfileEntityDTO> getAllProfiles() {
		return profileRepository.findAll().stream().map(x -> new ProfileEntityDTO(x.getPrfId(), x.getPrfName())).collect(Collectors.toList());
	}
	
	
}

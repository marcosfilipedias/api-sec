package com.personal.apisecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.personal.apisecurity.model.dto.ProfileEntityDTO;
import com.personal.apisecurity.service.ProfileService;

@Controller
@RequestMapping("/api/security/profile")
public class ProfileController {

	private final ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<ProfileEntityDTO> saveProfile(@RequestBody String profileJson) {
		ProfileEntityDTO profile = new Gson().fromJson(profileJson, ProfileEntityDTO.class);
		return ResponseEntity.ok(profileService.saveProfile(profile));
	}
}

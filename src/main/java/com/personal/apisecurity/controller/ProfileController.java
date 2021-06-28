package com.personal.apisecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.apisecurity.model.dto.ProfileEntityDTO;
import com.personal.apisecurity.service.ProfileService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/security/profile")
@AllArgsConstructor
public class ProfileController {

	private final ProfileService profileService;

	@PostMapping("/save")
	public ResponseEntity<ProfileEntityDTO> saveProfile(@RequestBody ProfileEntityDTO profile) {
		return ResponseEntity.ok(profileService.saveProfile(profile));
	}	
}

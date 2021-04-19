package com.personal.apisecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.model.dto.UserViewDTO;
import com.personal.apisecurity.service.UserService;

@Controller
@RequestMapping("/api/security/public/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserViewDTO> saveUser(@RequestBody String userJson) {
		UserEntityDTO user = new Gson().fromJson(userJson, UserEntityDTO.class);
		return ResponseEntity.ok(userService.saveUser(user));
	}
}

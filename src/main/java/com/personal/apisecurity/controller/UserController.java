package com.personal.apisecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public ResponseEntity<UserViewDTO> saveUser(@RequestBody UserEntityDTO userJson) {
		return ResponseEntity.ok(userService.saveUser(userJson));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserViewDTO> getUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<UserViewDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
}

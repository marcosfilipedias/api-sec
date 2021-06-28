package com.personal.apisecurity.controller;

import java.security.Principal;
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

import lombok.AllArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/security/user")
@AllArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<UserViewDTO> saveUser(@RequestBody UserEntityDTO userJson) {
		return ResponseEntity.ok(userService.saveUser(userJson));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	@GetMapping()
	public ResponseEntity<UserViewDTO> getUser(@ApiIgnore Principal principal){
		return ResponseEntity.ok(userService.getUserById(userService.getUserIdByLogin(principal.getName())));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserViewDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
}

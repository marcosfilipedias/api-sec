package com.personal.apisecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.model.dto.UserCredentialsDTO;
import com.personal.apisecurity.service.AuthService;

@Controller
@RequestMapping("/api/security/public/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping()
	public ResponseEntity<?> authenticate(@RequestBody UserCredentialsDTO userLogin, @RequestHeader String Authorization) {
		try {
			return ResponseEntity.ok(authService.authenticate(userLogin, Authorization));
		} catch (InvalidLoginException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}

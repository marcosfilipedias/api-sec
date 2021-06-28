package com.personal.apisecurity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.jwt.JWTConfigurer;
import com.personal.apisecurity.model.dto.JwtToken;
import com.personal.apisecurity.service.LoginService;
import com.personal.apisecurity.utils.SecurityConstants;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/security/login")
@AllArgsConstructor
public class LoginController {

	public static final String USERNAME_HEADER = "username";
	public static final String KEY_HEADER = "password";
	public static final String ORIGIN = "origin";
	
	private LoginService loginService;
	
	@PostMapping()
	public ResponseEntity<JwtToken> login(@RequestHeader(USERNAME_HEADER) String username, @RequestHeader(KEY_HEADER) String password, @RequestHeader(ORIGIN) String system){
		 
		try {
			String jwt = loginService.login(username, password, system);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(JWTConfigurer.AUTHORIZATION_HEADER, jwt);
			return new ResponseEntity<>(new JwtToken(SecurityConstants.JWT_PREFIX + jwt), httpHeaders, HttpStatus.OK);
			
		} catch (InvalidLoginException e) {
			return new ResponseEntity<>(new JwtToken(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(new JwtToken(e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
		
	}
}

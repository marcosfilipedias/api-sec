package com.personal.apisecurity.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.personal.apisecurity.exception.ExpirationTokenException;
import com.personal.apisecurity.exception.InvalidLoginException;
import com.personal.apisecurity.exception.InvalidTokenException;
import com.personal.apisecurity.model.dto.UserAuthDTO;
import com.personal.apisecurity.model.dto.UserCredentialsDTO;
import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.service.AuthService;
import com.personal.apisecurity.service.ProfileService;
import com.personal.apisecurity.service.TokenService;
import com.personal.apisecurity.service.UserService;
import com.personal.apisecurity.utils.SecurityConstants;

import io.jsonwebtoken.Claims;

@Service
public class AuthServiceImpl implements AuthService{

	private final UserService userService;
	private final TokenService tokenService;
	private final ProfileService profileService;
	
	public AuthServiceImpl(UserService userService, TokenService tokenService, ProfileService profileService) {
		super();
		this.userService = userService;
		this.tokenService = tokenService;
		this.profileService = profileService;
	}

	@Override
	public UserAuthDTO authenticate(UserCredentialsDTO userLogin, String token) throws InvalidLoginException {		
		UserEntityDTO user = userService.getUserByEmail(userLogin.getEmail());
		if(userLogin.getPassword().equals(user.getUsrPassword()) && !token.isEmpty() && validateToken(token)) {
			return new UserAuthDTO(user.getUsrId(), user.getUsrName(), profileService.getProfileById(user.getIdProfile()), SecurityConstants.TOKEN_PREFIX + tokenService.generateToken(user), true);
		}else {
			throw new InvalidLoginException("Invalid password!");
		}
	}

	private boolean validateToken(String token) {
		
		try {

			token = token.replaceAll(SecurityConstants.TOKEN_PREFIX, "");
			
			Claims claims = tokenService.decodeToken(token);
			
			System.out.println(claims.getIssuer());
			System.out.println(claims.getIssuedAt());
					
			if(claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpirationTokenException();
			
			System.out.println(claims.getExpiration());
			return true;
		}catch(ExpirationTokenException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException();
		}
	}
}

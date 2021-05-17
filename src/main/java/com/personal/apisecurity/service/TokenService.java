package com.personal.apisecurity.service;

import com.personal.apisecurity.model.dto.UserEntityDTO;

import io.jsonwebtoken.Claims;

public interface TokenService {

	public String generateToken(UserEntityDTO user);

	public Claims decodeToken(String token);

}

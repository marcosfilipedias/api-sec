package com.personal.apisecurity.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.personal.apisecurity.model.dto.UserEntityDTO;
import com.personal.apisecurity.service.TokenService;
import com.personal.apisecurity.utils.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService{

	@Override
	public String generateToken(UserEntityDTO user) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(user.getUsrName())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.compact();
	}

	@Override
	public Claims decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(token)
				.getBody();
	}
}

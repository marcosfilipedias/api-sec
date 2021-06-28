package com.personal.apisecurity.jwt;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.personal.apisecurity.model.dto.UserAuthDTO;
import com.personal.apisecurity.utils.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenProvider implements AbstractTokenProvider<Authentication>{

	@Override
	public String createToken(Authentication data, UserAuthDTO userAuthDTO, String sytem, Integer userProfile) {
		try {
			String jwt = JWT.create()
			        .withSubject(userAuthDTO.getLogin())
			        .withClaim(SecurityConstants.CLAIM_LOGIN, userAuthDTO.getLogin())
			        .withClaim(SecurityConstants.CLAIM_DETAIL, userAuthDTO.getId())
			        .withClaim(SecurityConstants.CLAIM_PROFILE, userProfile)
					.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
					.sign(Algorithm.HMAC256(SecurityConstants.SECRET));
			
			return jwt;
		} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Authentication getData(String token) {
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token).getBody();
		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE"));
		User principal = new User(claims.getSubject(), "", authorities);
		
		if(claims.get(SecurityConstants.CLAIM_DETAIL) != null) {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, null, authorities);
			authentication.setDetails(claims.get(SecurityConstants.CLAIM_DETAIL).toString());
			return authentication;
		}
		
		return  new UsernamePasswordAuthenticationToken(principal, null, authorities);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	public boolean validateToken(String authToken) {
        return this.validateToken(authToken, SecurityConstants.SECRET);
    }
}

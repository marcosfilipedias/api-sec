package com.personal.apisecurity.jwt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.personal.apisecurity.utils.SecurityConstants;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		String header = req.getHeader(SecurityConstants.HEADER_STRING);
		
		if (header == null || !header.startsWith(SecurityConstants.JWT_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) throws JWTVerificationException, IllegalArgumentException, UnsupportedEncodingException {
		String token = req.getHeader(SecurityConstants.HEADER_STRING);
		
		if(token != null) {
			DecodedJWT decodedToken = JWT.require(Algorithm.HMAC256(SecurityConstants.SECRET)).build().verify(token.replace(SecurityConstants.JWT_PREFIX, ""));
			String user = decodedToken.getSubject();
			String id = decodedToken.getClaim(SecurityConstants.CLAIM_DETAIL).asString();
			
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, id, new ArrayList<>());
			}
			return null;
		}
		
		return null;
	}
}

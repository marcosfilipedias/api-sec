package com.personal.apisecurity.utils;

public class SecurityConstants {

	public static final String SECRET = "6402cf55fda627cafed908cfdbea7333";
	public static final long EXPIRATION_TIME = 300000; // 5min
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String PUBLIC_URL = "/api/security/public/**";
	
	public static final String CLAIM_ID_USER = "id";
	public static final String CLAIM_SESSION_USER = "name";
	public static final String CLAIM_PROFILE = "profile";
	public static final String CLAIM_INFO = "info";
}

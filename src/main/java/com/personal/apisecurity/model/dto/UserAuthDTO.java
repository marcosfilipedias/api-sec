package com.personal.apisecurity.model.dto;

public class UserAuthDTO {
	
	private Integer userId;
	
	private String userName;

	private ProfileEntityDTO profile;
			
	private String token;
	
	private boolean authenticated;

	public UserAuthDTO() {
		super();
	}
	
	public UserAuthDTO(Integer userId, String userName, ProfileEntityDTO profile, String token, boolean authenticated) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.profile = profile;
		this.token = token;
		this.authenticated = authenticated;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ProfileEntityDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntityDTO profile) {
		this.profile = profile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

}

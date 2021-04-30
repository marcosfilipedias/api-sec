package com.personal.apisecurity.model.dto;

public class UserViewDTO {

	private Long usrId;
	
	private String usrName;
	
	private String usrEmail;
	
	private Boolean usrStatus;
	
	private Integer idProfile;

	public UserViewDTO() {
		super();
	}

	public UserViewDTO(Long usrId, String usrName, String usrEmail, Boolean usrStatus) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrStatus = usrStatus;
	}
	
	public UserViewDTO(Long usrId, String usrName, String usrEmail, Boolean usrStatus, Integer idProfile) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrStatus = usrStatus;
		this.idProfile = idProfile;
	}

	public Long getUsrId() {
		return usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public Boolean getUsrStatus() {
		return usrStatus;
	}

	public void setUsrStatus(Boolean usrStatus) {
		this.usrStatus = usrStatus;
	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

}

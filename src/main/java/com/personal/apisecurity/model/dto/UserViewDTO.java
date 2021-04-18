package com.personal.apisecurity.model.dto;

public class UserViewDTO {

	private Integer usrId;
	
	private String usrName;
	
	private String usrEmail;
	
	private Boolean usrStatus;

	public UserViewDTO() {
		super();
	}

	public UserViewDTO(Integer usrId, String usrName, String usrEmail, Boolean usrStatus) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrStatus = usrStatus;
	}

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
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
	
}

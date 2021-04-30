package com.personal.apisecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623263590606186788L;

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long usrId;
	
	@Column(name = "USR_NAME")
	private String usrName;
	
	@Column(name = "USR_EMAIL")
	private String usrEmail;
	
	@Column(name = "USR_PASSWORD")
	private String usrPassword;
	
	@Column(name = "USR_STATUS")
	private Boolean usrStatus;
	
	@ManyToOne()
	@JoinColumn(name="USR_PROFILE")
	private Profile profile;

	public User() {
		super();
	}

	public User(Long usrId, String usrName, String usrEmail, String usrPassword, Boolean usrStatus, Profile profile) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrPassword = usrPassword;
		this.usrStatus = usrStatus;
		this.profile = profile;
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

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Boolean getUsrStatus() {
		return usrStatus;
	}

	public void setUsrStatus(Boolean usrStatus) {
		this.usrStatus = usrStatus;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}

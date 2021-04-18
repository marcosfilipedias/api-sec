package com.personal.apisecurity.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776701799970579386L;

	@Id
	@Basic(optional = false)
	@Column(name = "PRL_ID")
	private Integer prfId;
	
	@Column(name = "PFL_NAME")
	private String prfName;

	public Integer getPrfId() {
		return prfId;
	}

	public void setPrfId(Integer prfId) {
		this.prfId = prfId;
	}

	public String getPrfName() {
		return prfName;
	}

	public void setPrfName(String prfName) {
		this.prfName = prfName;
	}
	
	
}

package com.personal.apisecurity.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "PFL_NAME")
	private String prfName;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPrfName() {
		return prfName;
	}

	public void setPrfName(String prfName) {
		this.prfName = prfName;
	}
	
	
}

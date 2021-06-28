package com.personal.apisecurity.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROFILE")
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776701799970579386L;

	@Id
	@Basic(optional = false)
	@Column(name = "PRL_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Getter @Setter private Integer Id;
	
	@Column(name = "PFL_NAME")
	@Getter @Setter private String prfName;
	
}

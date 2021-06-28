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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623263590606186788L;

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Getter private Integer usrId;
	
	@Column(name = "USR_NAME")
	@Getter @Setter private String usrName;
	
	@Column(name = "USR_EMAIL")
	@Getter @Setter private String usrEmail;
	
	@Column(name = "USR_PASSWORD")
	@Getter @Setter private String usrPassword;
	
	@Column(name = "USR_STATUS")
	@Getter @Setter private Boolean usrStatus;
	
	@ManyToOne()
	@JoinColumn(name="USR_PROFILE")
	@Getter @Setter private Profile profile;

}

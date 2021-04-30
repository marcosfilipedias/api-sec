package com.personal.apisecurity.model.dto;

public class ProfileEntityDTO {

	private Integer Id;
	
	private String prfName;
	
	public ProfileEntityDTO() {
		super();
	}	

	public ProfileEntityDTO(Integer id, String prfName) {
		super();
		Id = id;
		this.prfName = prfName;
	}
	
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

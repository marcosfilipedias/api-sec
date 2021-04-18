package com.personal.apisecurity.model.dto;

public class ProfileEntityDTO {

	private Integer prfId;
	
	private String prfName;
	
	public ProfileEntityDTO() {
		super();
	}

	public ProfileEntityDTO(Integer prfId, String prfName) {
		super();
		this.prfId = prfId;
		this.prfName = prfName;
	}

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

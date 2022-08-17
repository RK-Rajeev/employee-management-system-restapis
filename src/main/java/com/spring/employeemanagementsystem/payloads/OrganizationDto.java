package com.spring.employeemanagementsystem.payloads;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationDto {
	
	@ApiModelProperty(readOnly = true)
	private long id;
	private String orgName;
	


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	
	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

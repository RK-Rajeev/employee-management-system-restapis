package com.spring.employeemanagementsystem.payloads;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class LocationDto {
	
	@ApiModelProperty(readOnly = true)
	private long id;

	private String name;
	
//	private List<OrganizationDto> organizations;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

//	public List<OrganizationDto> getOrganizations() {
//		return organizations;
//	}
//
//	public void setOrganizations(List<OrganizationDto> organizations) {
//		this.organizations = organizations;
//	}

	public LocationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}

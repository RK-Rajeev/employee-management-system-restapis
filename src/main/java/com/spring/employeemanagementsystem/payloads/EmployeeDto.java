package com.spring.employeemanagementsystem.payloads;

import io.swagger.annotations.ApiModelProperty;

public class EmployeeDto {
	
	@ApiModelProperty(readOnly = true)
	private long id;

	private String name;
	
	
	private String email;

	private String address;
	
//	private OrganizationDto organization;

	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

//	public OrganizationDto getOrganization() {
//		return organization;
//	}
//
//	public void setOrganization(OrganizationDto organization) {
//		this.organization = organization;
//	}

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

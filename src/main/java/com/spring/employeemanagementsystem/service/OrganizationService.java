package com.spring.employeemanagementsystem.service;

import java.util.List;

import com.spring.employeemanagementsystem.entity.Organization;
import com.spring.employeemanagementsystem.payloads.LocationDto;
import com.spring.employeemanagementsystem.payloads.OrganizationDto;

public interface OrganizationService {
	
	public OrganizationDto addOrganization(OrganizationDto orgDto);
	
	public List<OrganizationDto> getOrganization();
	
	public List<LocationDto> orgByName(String name);
	
	public List<LocationDto> orgById(Long orgId);

	
	public OrganizationDto addLocationInOrg( Long orgId, Long locId);
	


}

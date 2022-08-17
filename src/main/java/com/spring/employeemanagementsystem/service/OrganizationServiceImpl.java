package com.spring.employeemanagementsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeemanagementsystem.entity.Location;
import com.spring.employeemanagementsystem.entity.Organization;
import com.spring.employeemanagementsystem.exceptions.ResouceNotFoundException;
import com.spring.employeemanagementsystem.payloads.LocationDto;
import com.spring.employeemanagementsystem.payloads.OrganizationDto;
import com.spring.employeemanagementsystem.repository.LocationRepository;
import com.spring.employeemanagementsystem.repository.OrganizationRepository;


@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public OrganizationDto addOrganization(OrganizationDto orgDto) {
		
		Organization org = this.dtoToOrg(orgDto);
		
		Organization saveOrg = this.organizationRepository.save(org);
		 	
		return this.orgToDto(saveOrg);
	}

	public List<OrganizationDto> getOrganization() {

		List<Organization> orgs = this.organizationRepository.findAll();
		 
		  List<OrganizationDto> orgDtos = orgs.stream()
				  .map(org -> this.orgToDto(org)).collect(Collectors.toList());
		  return orgDtos;
	}
	
	public Organization dtoToOrg(OrganizationDto orgDto)
	{
		Organization org = this.modelMapper.map(orgDto, Organization.class);
		
		return org;
	}
	
	public OrganizationDto orgToDto(Organization org) {
		
		OrganizationDto orgDto = this.modelMapper.map(org, OrganizationDto.class);
		
		return orgDto;
		
	}

	@Override
	public List<LocationDto> orgByName(String name) {
		
		Organization org = this.organizationRepository.findByName(name);
		
		List<Location> locs = org.getLocations();
		 
		  List<LocationDto> locDtos = locs.stream()
				  .map(loc -> this.modelMapper.map(loc, LocationDto.class)).collect(Collectors.toList());
		  
		  return locDtos;
		
	}

	@Override
	public OrganizationDto addLocationInOrg(Long orgId, Long locId) {
		
		
		 Organization org = organizationRepository.findById(orgId).get();
		 Location loc = locationRepository.findById(locId).get();
		 
		 org.addLocation(loc);
		 
		 Organization newOrg = organizationRepository.save(org);
		 
		
		return this.modelMapper.map(newOrg, OrganizationDto.class);
	}

	@Override
	public List<LocationDto> orgById(Long orgId) {
		
		Organization org = organizationRepository.findById(orgId).orElseThrow(() -> new ResouceNotFoundException("OrgLocation","id",orgId));
		
		List<Location> locs = org.getLocations();
		 
		  List<LocationDto> locDtos = locs.stream()
				  .map(loc -> this.modelMapper.map(loc, LocationDto.class)).collect(Collectors.toList());
		  
		  return locDtos;
		
	}

	

}



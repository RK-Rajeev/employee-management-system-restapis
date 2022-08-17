package com.spring.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.employeemanagementsystem.entity.Organization;
import com.spring.employeemanagementsystem.payloads.LocationDto;
import com.spring.employeemanagementsystem.payloads.OrganizationDto;
import com.spring.employeemanagementsystem.service.OrganizationService;

@RestController
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	
	@PostMapping("/orgs")
	public ResponseEntity<OrganizationDto> addOrg(@RequestBody OrganizationDto orgDto) {
		
		 OrganizationDto organizationDto = this.organizationService.addOrganization(orgDto);
		 
		return new ResponseEntity<>(organizationDto , HttpStatus.CREATED);

	}
	
	@GetMapping(path = "/orgs")
	public ResponseEntity<List<OrganizationDto>> getOrgs(){
		
			return ResponseEntity.ok(this.organizationService.getOrganization());
	
	}

	@GetMapping("/org")
	public ResponseEntity<List<LocationDto>> locationsByOrgName(@RequestParam String name) {
		
		return ResponseEntity.ok(this.organizationService.orgByName(name));
	}
	
	@GetMapping("/org/{orgId}")
	public ResponseEntity<List<LocationDto>> locationsByOrgId(@PathVariable("orgId") Long orgId) {
		
		return ResponseEntity.ok(this.organizationService.orgById(orgId));
	}
	

	@PutMapping("/orgs/{orgId}/locations/{locId}")
	public ResponseEntity<?> addLocationInOrg( @PathVariable("orgId") Long orgId, @PathVariable("locId") Long locId) {
		
		 this.organizationService.addLocationInOrg(orgId,locId);
		 
		 return new ResponseEntity<>("Location added successfully", HttpStatus.OK);
	}
	
	
	
}

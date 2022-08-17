package com.spring.employeemanagementsystem.service;

import java.util.List;

import com.spring.employeemanagementsystem.payloads.LocationDto;

public interface LocationService {
	

	
	public LocationDto addLocation( LocationDto locationDto );
	
	public List<LocationDto> getLocation ();
	
//	public List<LocationDto> getLocByOrgName (String orgName);

}

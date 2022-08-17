package com.spring.employeemanagementsystem.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeemanagementsystem.entity.Location;
import com.spring.employeemanagementsystem.entity.Organization;
import com.spring.employeemanagementsystem.payloads.LocationDto;
import com.spring.employeemanagementsystem.payloads.OrganizationDto;
import com.spring.employeemanagementsystem.repository.LocationRepository;
import com.spring.employeemanagementsystem.repository.OrganizationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private ModelMapper modelMapper;



	@Override
	public LocationDto addLocation(LocationDto locationDto) {
		
		Location loc = this.modelMapper.map(locationDto, Location.class);
		Location saveLoc = this.locationRepository.save(loc);
		return this.modelMapper.map(saveLoc, LocationDto.class);
		
	}

	@Override
	public List<LocationDto> getLocation() {
		List<Location> locs = this.locationRepository.findAll();
		 
		  List<LocationDto> locDtos = locs.stream()
				  .map(loc -> this.modelMapper.map(loc, LocationDto.class)).collect(Collectors.toList());
		  return locDtos;

		
		
	}



}

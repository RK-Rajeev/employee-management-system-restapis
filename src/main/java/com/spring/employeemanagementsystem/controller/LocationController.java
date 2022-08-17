package com.spring.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeemanagementsystem.payloads.LocationDto;
import com.spring.employeemanagementsystem.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/locations")
	public ResponseEntity<LocationDto> addLocation(@RequestBody LocationDto locationDto) {
		
		 LocationDto addLocation = this.locationService.addLocation(locationDto);
		 
		 return new ResponseEntity<>(addLocation , HttpStatus.CREATED);

	}
	
	@GetMapping("/locations")
	public ResponseEntity<List<LocationDto>> getLocation(){
		
		return ResponseEntity.ok(this.locationService.getLocation());
	}
	
	
	

	

}

package com.spring.employeemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "org_name")
	private String orgName;
	
	
	
	@OneToMany(mappedBy = "organization" ,cascade = CascadeType.ALL , fetch  = FetchType.LAZY )
	private List<Employee> employees = new ArrayList<Employee>(); 
	
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH} , fetch  = FetchType.LAZY )
	@JoinTable(name = "org_loc",
	joinColumns = @JoinColumn(name = "org_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "loc_id", referencedColumnName = "id"))
	private List<Location> locations = new ArrayList<Location>(); 
	
	
	
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

	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public void addLocation(Location location) {
		
		locations.add(location);
		
	}
	
	

}

package com.spring.employeemanagementsystem.service;

import java.util.List;

import com.spring.employeemanagementsystem.entity.Employee;
import com.spring.employeemanagementsystem.payloads.EmployeeDto;



public interface EmployeeService {
	
	public EmployeeDto addEmployee(EmployeeDto empDto , Long orgId);
	
	public List<EmployeeDto> getAllEmployee();

	public EmployeeDto getEmployeeById(long empId);
	 
	public EmployeeDto updateEmployee(EmployeeDto empDto , long empId);
	
	public void deleteEmployee(long parseLong);
	
	public List<EmployeeDto> getEmployeeByName(String name);
	
	public List<EmployeeDto> getEmployeeByOrgName(String name);
	
	public EmployeeDto updateEmplLoc(EmployeeDto empDto , long empId);
	
	

}

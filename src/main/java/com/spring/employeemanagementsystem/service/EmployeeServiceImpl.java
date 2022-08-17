package com.spring.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeemanagementsystem.entity.Employee;
import com.spring.employeemanagementsystem.entity.Organization;
import com.spring.employeemanagementsystem.exceptions.ResouceNotFoundException;
import com.spring.employeemanagementsystem.payloads.EmployeeDto;
import com.spring.employeemanagementsystem.repository.EmployeeRepository;
import com.spring.employeemanagementsystem.repository.OrganizationRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private ModelMapper modelMapper;


	
	@SuppressWarnings("deprecation")
	public EmployeeDto addEmployee(EmployeeDto empDto, Long orgId) {
		
		Organization org = organizationRepository.getOne(orgId);
		
		Employee emp = this.modelMapper.map(empDto, Employee.class);
		
		
		emp.setOrganization(org);
		
		
		Employee newEmp = employeeRepository.save(emp);
		
		return this.modelMapper.map(newEmp, EmployeeDto.class);
	}


	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		List<Employee> allEmp = this.employeeRepository.findAll();
		
		List<EmployeeDto> empDtos = allEmp.stream().map((emp) -> this.modelMapper.map(emp, EmployeeDto.class))
		.collect(Collectors.toList());
		
		return empDtos;
	}



	public EmployeeDto getEmployeeById(long empId) {
		
		Employee emp = this.employeeRepository.findById(empId).orElseThrow(() -> new ResouceNotFoundException("Employe","id",empId));
		
		return this.modelMapper.map(emp, EmployeeDto.class);
	}
	

	
	
	public EmployeeDto updateEmployee(EmployeeDto empDto, long empId) {
		
		
		 Employee emp = employeeRepository.findById(empId).orElseThrow(() -> new ResouceNotFoundException("Employe","id",empId));
		 
		 emp.setName(empDto.getName());
		 
		 Employee updatedEmp = this.employeeRepository.save(emp);
		
		
		return this.modelMapper.map(updatedEmp, EmployeeDto.class);
	}

	

	@SuppressWarnings("deprecation")
	public void deleteEmployee(long parseLong) {
		
		Employee entity = employeeRepository.getOne(parseLong);
		employeeRepository.delete(entity);
		
	}


	
	public List<EmployeeDto> getEmployeeByName(String name) {
		List<Employee> allEmp = employeeRepository.findByName(name);
		
		List<EmployeeDto> empDtos = allEmp.stream().map((emp) -> this.modelMapper.map(emp, EmployeeDto.class))
				.collect(Collectors.toList());
		
		return empDtos;
	}


	@Override
	public List<EmployeeDto> getEmployeeByOrgName(String name) {
		
		Organization org = organizationRepository.findByName(name);
		long orgId = org.getId();
		List<Employee> emps = employeeRepository.findByid(orgId);
		
		List<EmployeeDto> empDtos = emps.stream().map((emp) -> this.modelMapper.map(emp, EmployeeDto.class))
				.collect(Collectors.toList());
		
		return empDtos;
	}


	
	@Override
	public EmployeeDto updateEmplLoc(EmployeeDto empDto, long empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(() -> new ResouceNotFoundException("Employe","id",empId));
		 
		 emp.setAddress(empDto.getAddress());
		 
		 Employee updatedEmp = this.employeeRepository.save(emp);
		
		
		return this.modelMapper.map(updatedEmp, EmployeeDto.class);
	}


	

	
}

package com.spring.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeemanagementsystem.entity.Employee;
import com.spring.employeemanagementsystem.payloads.EmployeeDto;
import com.spring.employeemanagementsystem.repository.ApiResponse;
import com.spring.employeemanagementsystem.service.EmployeeService;



@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	
	@PostMapping("/org/{orgId}/employees")
	public ResponseEntity<EmployeeDto> addEmp(@RequestBody EmployeeDto empDto,@PathVariable("orgId") Long orgId) {
		
		EmployeeDto employeeDto = this.employeeService.addEmployee(empDto, orgId);
		
		return new ResponseEntity<>(employeeDto , HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<EmployeeDto> updateEmpName(@RequestBody EmployeeDto empDto , @PathVariable("empId") Long empId) {
		
		 EmployeeDto updateEmployee = this.employeeService.updateEmployee(empDto, empId);
		 
		 return ResponseEntity.ok(updateEmployee);
				 
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> geAllEmployee(){
		
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
		
	} 
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<EmployeeDto> getEmpById(@PathVariable("empId") Long empId){
		
		return ResponseEntity.ok(this.employeeService.getEmployeeById(empId));
		
	}
	
	@DeleteMapping("employees/{empId}")
	public ResponseEntity<ApiResponse> deleteEmp(@PathVariable String empId) {
		
		this.employeeService.deleteEmployee(Long.parseLong(empId));
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Employee deleted Succesfuly.",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getEmployeeByName(@RequestParam String name){
		
		return ResponseEntity.ok(this.employeeService.getEmployeeByName(name)) ;
		
	}
	
	@GetMapping("/employeebyorg")
	public ResponseEntity<List<EmployeeDto>> getEmployeeByOrgName(@RequestParam String orgName){
		
		
		return ResponseEntity.ok(this.employeeService.getEmployeeByOrgName(orgName));
	}
	
	@PutMapping("/emploc/{empId}")
	public ResponseEntity<EmployeeDto>updateEmplLoc(@RequestBody EmployeeDto empDto , @PathVariable("empId") Long empId) {
		
		return ResponseEntity.ok(this.employeeService.updateEmplLoc(empDto, empId));
	}

}

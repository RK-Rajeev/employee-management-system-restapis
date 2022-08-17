package com.spring.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.employeemanagementsystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "select e from Employee e where e.name = :name")
	List<Employee> findByName(@Param("name") String name);
	
	@Query(value = "select e from Employee e where e.organization.id = :orgId")
	List<Employee> findByid(@Param("orgId") Long orgId);
	
	
	
	
	


}

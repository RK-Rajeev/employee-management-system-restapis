package com.spring.employeemanagementsystem.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.employeemanagementsystem.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
	
	@Query(value = "select o from Organization o where o.orgName = :name")
	Organization findByName(@Param("name") String name);
	
	
	


}





package com.fedex.intellisense.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.intellisense.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

	
	Logger log = LogManager.getLogger(EmployeeRepository.class);
	
	@Query(value = "SELECT USER_ID, USER_NAME, USER_PWD FROM USERS", nativeQuery = true)
	public void getUsers();
	
	public Employee save(Employee employee);
	
	@Query(value = "SELECT EMP_NBR, EMP_NAME, EMP_PWD, EMP_EMAIL_ID, EMP_MGR_NBR, ALPHA_CODE, BUS_ID_NBR FROM EMPLOYEE WHERE EMP_NAME = :userName AND EMP_PWD = :userPassword", nativeQuery = true)
	Employee login( @Param("userName") String userName , @Param("userPassword") String userPassword);
	
	
}

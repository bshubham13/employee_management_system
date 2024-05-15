package com.qsp.employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	Employee findByPhone(long phone);
	Employee getByEmail(String email);
	
	@Query("SELECT e FROM Employee e WHERE e.name = ?1")
    List<Employee> findByName(String name);
	
	@Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmail(String email);
	
	@Query("SELECT e FROM Employee e WHERE e.address = ?1")
    List<Employee> findByAddress(String address);
	
	@Query("SELECT e FROM Employee e WHERE e.designation = ?1")
    List<Employee> findByDesignation(String designation);
	
	
	public List<Employee> findBySalaryLessThan(double salary);
	public List<Employee> findBySalaryGreaterThan(double salary);
	public List<Employee> findBySalaryBetween(double salary, double salary2);
 


	

	

}

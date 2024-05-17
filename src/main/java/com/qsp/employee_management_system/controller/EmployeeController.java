package com.qsp.employee_management_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("/employee") // URL: http://localhost:8080
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	@Autowired 
	private EmployeeService service; 

	//****************************************   FOR SAVE  *************************************************************

	// Method for saving data , @RequestBody is used to convert JSON data into java object.
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee); 
	}
 
	@PostMapping("/saveall")
	public List<Employee> saveEmployeeAll(@RequestBody List<Employee> list) {
		return service.saveEmployeeAll(list);
 
	}
	
	//****************************************   FOR LOGIN  *************************************************************

	@GetMapping("/login")
	public String loginEmployee(@RequestParam String userName, @RequestParam String password) {
		  return service.getEmployee(userName,password);
		 	} 
	
	
	//****************************************   FOR FILTER  *************************************************************

	@GetMapping("/salary/lessthan")
	public List<Employee> findBySalaryLessThan(@RequestParam double salary) {
		return service.findBySalaryLessThan(salary); 
	}
	
	@GetMapping("/salary/greaterthan")
	public List<Employee> findBySalaryGreaterThan(@RequestParam double salary) {
		return service.findBySalaryGreaterThan(salary);
	}
	
	@GetMapping("/salary/between")
	public List<Employee> findBySalaryBetween(@RequestParam double salary, @RequestParam double salary2) {
		return service.findBySalaryBetween(salary,salary2);  
	}
	
	
	//****************************************   FOR UPDATE  *************************************************************
	
	 @PutMapping("/update")
	    public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee) {
	        return service.updateEmployee(id, employee);
	    } 
	 
	 @PutMapping("/update/phone")
	    public Employee updateEmployeePhone(@RequestParam int id, @RequestParam long phone) {
	        return service.updateEmployeePhone(id, phone);
	    }
	 
	 @PutMapping("/update/email")
	    public Employee updateEmployeeEmail(@RequestParam int id, @RequestParam String email) {
	        return service.updateEmployeeEmail(id, email);
	    }
	 
	 @PutMapping("/update/salary")
	    public Employee updateEmployeeSalary(@RequestParam int id, @RequestParam double salary) {
	        return service.updateEmployeeSalary(id, salary);
	    }
	 
	 @PutMapping("/update/designation")
	 public Employee updateEmployeeDesignation(@RequestParam int id, @RequestParam String designation) {
	        return service.updateEmployeeDesignation(id, designation);
	    }
	 
	 @PutMapping("/update/name")
	    public Employee updateEmployeeName(@RequestParam int id, @RequestParam String name) {
	        return service.updateEmployeeName(id, name);
	    }
	 
	  @PutMapping("/update/password")
	    public Employee updateEmployeePassword(@RequestParam int id, @RequestParam String password) {
	        return service.updateEmployeePassword(id, password);
	    }
	   
	  
		//****************************************   FOR FETCH  *************************************************************

	  
	  @GetMapping("/fetch")
	    public Optional<Employee> fetch(@RequestParam int id) {
	        return service.findEmployeeById(id);
	    }
	  
	  @GetMapping("/fetch/name") 
	    public List<Employee> fetchByName(@RequestParam String name) {
	        return service.fetchByName(name);
	    }
	  
	  @GetMapping("/fetch/phone")
	    public Employee fetchByPhone(@RequestParam long phone) {
	        return service.fetchByPhone(phone);
	    }
	  
	  @GetMapping("/fetch/mail")
	    public Employee fetchByEmail(@RequestParam String email) {
	        return service.fetchByEmail(email);
	    }
	  
	  @GetMapping("/fetch/address")
	    public List<Employee> fetchByAddress(@RequestParam String address) {
	        return service.fetchByAddress(address);
	    }
	  
	  @GetMapping("/fetch/designation")
	    public List<Employee> fetchByDesignation(@RequestParam String designation) {
	        return service.fetchByDesignation(designation); 
	    }
	  
	  @GetMapping("/fetchall")
	    public List<Employee> fetchAll() {
	        return service.fetchAll();
	    }
	  
	  @GetMapping("/fetch/salarylessthan")
	    public List<Employee> fetchBySalaryLessThan(@RequestParam double salary) {
	        return service.fetchBySalaryLessThan(salary);
	    }
	  
	  @GetMapping("/fetch/salarygreaterthan")
	    public List<Employee> fetchBySalaryGreaterThan(@RequestParam double salary) {
	        return service.fetchBySalaryGreaterThan(salary);
	    }
	  
	  @GetMapping("/fetch/salarybetween")
	    public List<Employee> fetchBySalaryBetween(@RequestParam double salary, @RequestParam double salary2) {
	        return service.fetchBySalaryBetween(salary, salary2);
	    } 
	   
	  
		//****************************************   FOR DELETE  *************************************************************
	  
	  
	  @DeleteMapping("/delete")
	    public String deleteEmployeeById(@RequestParam int id) {
	        return service.deleteEmployeeById(id);
	    }
	  
	  @DeleteMapping("/delete/phone")
	    public String deleteEmployeeByPhone(@RequestParam long phone) {
	        return service.deleteEmployeeByPhone(phone); 
	    }
	  
	  @DeleteMapping("/delete/email")
	    public String deleteEmployeeByEmail(@RequestParam String email) {
	        return service.deleteEmployeeByEmail(email);
	    }
	   
	  @DeleteMapping("/delete/name")
	    public String deleteEmployeesByName(@RequestParam String name) {
	        return service.deleteEmployeesByName(name);
	    }
	  
	  @DeleteMapping("/delete/designation")
	    public String deleteEmployeesByDesignation(@RequestParam String designation) {
	        return service.deleteEmployeesByDesignation(designation);
	    }
	  
	  @DeleteMapping("/delete/address")
	    public String deleteEmployeesByAddress(@RequestParam String address) {
	        return service.deleteEmployeesByAddress(address); 
	    } 


}
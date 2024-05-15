package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@RestController
@RequestMapping("/employee") // URL: http://localhost:8080
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	// Method for saving data , @RequestBody is used to convert JSON data into java
	// object.
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return dao.saveEmployee(employee);
	}

	@PostMapping("/saveall")
	public List<Employee> saveEmployeeAll(@RequestBody List<Employee> list) {
		return dao.saveEmployees(list);
 
	}

	@GetMapping("/login")
	public String loginEmployee(@RequestParam String userName, @RequestParam String password) {
		Employee employee = dao.getEmployee(userName);
		if (employee != null) {
			if (password.equals(employee.getPassword())) {
				return "Login Success";
			} else {
				return "invalid password";
			}
		} else {
			return "Employee not found"; 
		}
	}

//	@GetMapping("/fetch")
//	public Optional<Employee> fetch(Integer id) {
//		
//		Optional<Employee> person =repo.findById(id);
//		if(person.isPresent()) {
//			return person;
//		} else {
//			return null; 
//		}
//	}

//	//findby phone using custom method created in PersonRepo.java
//	@GetMapping("/fetchbyphone")
//	public Employee fetchByPhone(@RequestParam long phone) {
//		
//		return repo.findByPhone(phone); 
//		 
//	}
//	
//	
//	@GetMapping("/fetchbyaddress")
//	public List<Employee> fetchByAddress(@RequestParam  String address) {
//		return repo.findByAddress(address);  
//	}
//	
//	
//	@GetMapping("/fetchall")
//	public List<Employee> fetchAll() {
//		return repo.findAll(); 
//				
//	} 
//	
//	
//	// @RequestParam used to bind the data 
//	@DeleteMapping("/delete")
//	public String deletePerson(@RequestParam int id) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isEmpty()) {
//			return "person with id " + id + " not found";
//		}
//		else 
//		{
//			repo.delete(optional.get());
//			return "deleted Successfully"; 
//		}
//		
//	}
//	
//	@PutMapping("/update")
//	public String updatePerson(@RequestParam  int id, @RequestBody Employee employee) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			employee.setId(id);
//			repo.save(employee);
//			return "Updated Successfully";
//		} else {
//			return "person with id " +id+ " not found" ;
//
//		}
//
//	}
//	
//	@PatchMapping("/update/phone/{id}/{phone}")
//	public String updatePhone(@PathVariable int id, @PathVariable  long phone) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			Employee person=optional.get();
//			person.setPhone(phone);
//			
//			repo.save(person);
//			return "Update Success";
//		} else {
//			return "person with id " +id+ " not found" ; 
//		}	
//	}
//	
//	@PatchMapping("/update/email/{id}/{email}")
//	public String updateEmail(@PathVariable int id, @PathVariable  String email) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			Employee employee=optional.get();
//			employee.setEmail(email);
//			
//			repo.save(employee);
//			return "Update Success";
//		} else {
//			return "person with id " +id+ " not found" ; 
//		}	
//	}
//	
//	@PatchMapping("/update/name/{id}/{name}")
//	public String updateName(@PathVariable int id, @PathVariable  String name) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			Employee employee=optional.get();
//			employee.setName(name);
//			
//			repo.save(employee);
//			return "Update Success";
//		} else {
//			return "person with id " +id+ " not found" ; 
//		}	
//	}
//	
//	@PatchMapping("/update/password/{id}/{password}")
//	public String updatePassword(@PathVariable int id, @PathVariable  String password) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			Employee employee=optional.get();
//			employee.setPassword(password);
//			
//			repo.save(employee);
//			return "Update Success";
//		} else {
//			return "person with id " +id+ " not found" ; 
//		}	
//	}
//	
//	@PatchMapping("/update/address/{id}/{address}")
//	public String updateAddress(@PathVariable int id, @PathVariable  String address) {
//		
//		Optional<Employee> optional =repo.findById(id);
//		if(optional.isPresent()) {
//			Employee employee=optional.get();
//			employee.setAddress(address);
//			
//			repo.save(employee); 
//			return "Update Success";
//		} else {
//			return "person with id " +id+ " not found" ; 
//		}	
//	} 

}

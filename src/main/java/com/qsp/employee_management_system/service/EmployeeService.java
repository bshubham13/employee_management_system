package com.qsp.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@Service 
public class EmployeeService {
	@Autowired 
	private EmployeeDao dao;
	
	//****************************************   FOR SAVE  *************************************************************

	public Employee saveEmployee( Employee employee) {
		double salary = employee.getSalary();
		if(salary<=10000) {
			employee.setGrade('D');
		} else if(salary>10000 && salary <=20000) {
			employee.setGrade('C');
		} else if(salary>20000 && salary<=40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		return dao.saveEmployee(employee);
	}
	
	public List<Employee> saveEmployeeAll( List<Employee> list) {
		
		
		for(Employee employee:list)
		{
		double salary = employee.getSalary();
		if(salary<=10000) {
			employee.setGrade('D');
		} else if(salary>10000 && salary <=20000) {
			employee.setGrade('C');
		} else if(salary>20000 && salary<=40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}  
		}
		
		return dao.saveEmployees(list);
 
	}
	
	
	
	//****************************************   FOR LOGIN  *************************************************************


	public String getEmployee(String userName,String password) {
		 return dao.getEmployee(userName,password); 
	}
	
	
	
	//****************************************   FOR FILTER  *************************************************************

	
	
	public List<Employee> findBySalaryLessThan(double salary) {
		return dao.findBySalaryLessThan(salary);
	}
	
	public List<Employee> findBySalaryGreaterThan(double salary) {
		return dao.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findBySalaryBetween( double salary, double salary2) {
		return dao.findBySalaryBetween(salary,salary2); 
	}
	
	
	
	//****************************************   FOR UPDATE  *************************************************************

	
    public Employee updateEmployee( int id,  Employee employee) {
        return dao.updateEmployee(id, employee);
    } 
    
    public Employee updateEmployeePhone( int id,  long phone) {
        return dao.updateEmployeePhone(id, phone);
    }
    
    public Employee updateEmployeeEmail( int id,  String email) {
        return dao.updateEmployeeEmail(id, email);
    }
 
    public Employee updateEmployeeSalary( int id,  double salary) {
        return dao.updateEmployeeSalary(id, salary);
    }
 
 public Employee updateEmployeeDesignation( int id,  String designation) {
        return dao.updateEmployeeDesignation(id, designation);
    }
 
    public Employee updateEmployeeName( int id,  String name) {
        return dao.updateEmployeeName(id, name);
    }
 
    public Employee updateEmployeePassword( int id,  String password) {
        return dao.updateEmployeePassword(id, password); 
    }
	
    
	//****************************************   FOR FETCH  *************************************************************

    
    
    
    public Optional<Employee> findEmployeeById( int id) {
        return dao.findEmployeeById(id); 
    }
  
    public List<Employee> fetchByName( String name) {
        return dao.findEmployeeByName(name);
    }
  
    public Employee fetchByPhone( long phone) {
        return dao.findEmployeeByPhone(phone);
    }
  
    public Employee fetchByEmail( String email) {
        return dao.findEmployeeByEmail(email);
    }
  
    public List<Employee> fetchByAddress( String address) {
        return dao.findEmployeesByAddress(address);
    }
  
    public List<Employee> fetchByDesignation( String designation) {
        return dao.findEmployeesByDesignation(designation); 
    }
  
    public List<Employee> fetchAll() {
        return dao.findAllEmployees();
    }
  
    public List<Employee> fetchBySalaryLessThan( double salary) {
        return dao.findEmployeesWithSalaryLessThan(salary);
    }
  
    public List<Employee> fetchBySalaryGreaterThan( double salary) {
        return dao.findEmployeesWithSalaryGreaterThan(salary);
    }
  
    public List<Employee> fetchBySalaryBetween( double salary,  double salary2) {
        return dao.findEmployeesWithSalaryBetween(salary, salary2);
    } 
	
	
    
	//****************************************   FOR DELETE  *************************************************************

    
  
    public String deleteEmployeeById( int id) {
        return dao.deleteEmployeeById(id);
    }
   
    public String deleteEmployeeByPhone( long phone) {
        return dao.deleteEmployeeByPhone(phone); 
    }
  
    public String deleteEmployeeByEmail( String email) {
        return dao.deleteEmployeeByEmail(email);
    }
   
    public String deleteEmployeesByName( String name) {
        return dao.deleteEmployeesByName(name);
    }
  
    public String deleteEmployeesByDesignation( String designation) {
        return dao.deleteEmployeesByDesignation(designation);
    }
  
    public String deleteEmployeesByAddress( String address) {
        return dao.deleteEmployeesByAddress(address); 
    }

	
} 



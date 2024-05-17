package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	//****************************************   FOR SAVE  *************************************************************

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);

	}

	public List<Employee> saveEmployees(@RequestBody List<Employee> list) {
		return repo.saveAll(list);
	}

	//****************************************   FOR LOGIN  *************************************************************

	public Employee findEmployee(long phone) {
		return repo.findByPhone(phone);
	}

	public Employee findEmployee(String email) {
		return repo.getByEmail(email);
	}

	public String getEmployee(String userName, String password) {
		try {
			long phone = Long.parseLong(userName);
		 	Employee employee= findEmployee(phone);
			if (employee != null) {
				if (password.equals(employee.getPassword())) {
					return "Login Success";
				} else {
					return "invalid password";
				}
			} else {
				return "Employee not found"; 
			}
			
			 
		} catch (Exception e) {
			String email = userName;
			Employee employee=findEmployeeByEmail(email); 
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
	}
	
	
	//****************************************   FOR FILTER  *************************************************************

	
	public List<Employee> findBySalaryLessThan(double salary) {
		return repo.findBySalaryLessThan(salary); 
	}
	
	public List<Employee> findBySalaryGreaterThan(double salary) {
		return repo.findBySalaryGreaterThan(salary); 
	}
	
	public List<Employee> findBySalaryBetween(double salary, double salary2) {
		return repo.findBySalaryBetween(salary,salary2);  
	}
	
	
	
	//****************************************   FOR UPDATE  *************************************************************


	public Employee updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            updatedEmployee.setId(id);
            return repo.save(updatedEmployee);
        } else {
            return null; // Or you can throw an exception indicating that the employee with the given ID was not found
        }
    }
	
	public Employee updateEmployeePhone(int id, long phone) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setPhone(phone);
            return repo.save(employee); 
        } else { 
            return null; 
        }
    }
	
	
	public Employee updateEmployeeEmail(int id, String email) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setEmail(email);
            return repo.save(employee);
        } else {
            return null; 
        }
    }
	
	 public Employee updateEmployeeSalary(int id, double salary) {
	        Optional<Employee> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Employee employee = optional.get();
	            employee.setSalary(salary);
	            return repo.save(employee);
	        } else {
	            return null;
	        }
	    }
	 
	 public Employee updateEmployeeDesignation(int id, String designation) {
	        Optional<Employee> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Employee employee = optional.get();
	            employee.setDesignation(designation);
	            return repo.save(employee);
	        } else {
	            return null; 
	        }
	    }
	 
	 public Employee updateEmployeeName(int id, String name) {
	        Optional<Employee> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Employee employee = optional.get();
	            employee.setName(name);
	            return repo.save(employee);
	        } else {
	            return null;  
	        }
	    }
	 
	 public Employee updateEmployeePassword(int id, String password) {
	        Optional<Employee> optional = repo.findById(id);
	        if (optional.isPresent()) {
	            Employee employee = optional.get();
	            employee.setPassword(password);
	            return repo.save(employee);
	        } else {
	            return null;  
	        }
	    }
	 
	 
	 
		//****************************************   FOR FETCH  *************************************************************

	 
	 
	 public Optional<Employee> findEmployeeById(int id) {
	        return repo.findById(id);
	    }
	  
	 public List<Employee> findEmployeeByName(String name) {
	        return repo.findByName(name);
	    }
	 	 
	 public Employee findEmployeeByPhone(long phone) {
	        return repo.findByPhone(phone);
	    }
	 
	 public Employee findEmployeeByEmail(String email) {
	        return repo.findByEmail(email);
	    }
	 
	 public List<Employee> findEmployeesByAddress(String address) {
	        return repo.findByAddress(address);
	    }
	 
	 public List<Employee> findEmployeesByDesignation(String designation) {
	        return repo.findByDesignation(designation);
	    }
	 
	 public List<Employee> findAllEmployees() {
	        return repo.findAll();
	    }
	 
	 public List<Employee> findEmployeesWithSalaryLessThan(double salary) {
	        return repo.findBySalaryLessThan(salary);
	    }
	 
	 public List<Employee> findEmployeesWithSalaryGreaterThan(double salary) {
	        return repo.findBySalaryGreaterThan(salary);
	    }
	 
	 public List<Employee> findEmployeesWithSalaryBetween(double salary, double salary2) {
	        return repo.findBySalaryBetween(salary, salary2);
	    }
	 
	 
		//****************************************   FOR DELETE  *************************************************************

	 
	 public String deleteEmployeeById(int id) {
	        Optional<Employee> optionalEmployee = repo.findById(id);
	        if (optionalEmployee.isPresent()) {
	            repo.delete(optionalEmployee.get());
	            return "Deleted Successfully";
	        } else {
	            return "Employee with id " + id + " not found";
	        }
	    }
	 
	 public String deleteEmployeeByPhone(long phone) {
	        Employee employee = repo.findByPhone(phone);
	        if (employee != null) {
	            repo.delete(employee);
	            return "Deleted Successfully";
	        } else {
	            return "Employee with phone number " + phone + " not found";
	        }
	    }
	 
	 public String deleteEmployeeByEmail(String email) {
	        Employee employee = repo.getByEmail(email);
	        if (employee != null) {
	            repo.delete(employee);
	            return "Deleted Successfully";
	        } else {
	            return "Employee with email " + email + " not found";
	        }
	    }
	 
	 public String deleteEmployeesByName(String name) {
	        List<Employee> employees = repo.findByName(name);
	        if (!employees.isEmpty()) {
	            repo.deleteAll(employees);
	            return "Deleted Successfully";
	        } else {
	            return "Employees with name " + name + " not found";
	        }
	    }
	 
	 public String deleteEmployeesByDesignation(String designation) {
	        List<Employee> employees = repo.findByDesignation(designation);
	        if (!employees.isEmpty()) {
	            repo.deleteAll(employees);
	            return "Deleted Successfully";
	        } else {
	            return "Employees with designation " + designation + " not found";
	        }
	    }
	 
	 public String deleteEmployeesByAddress(String address) {
	        List<Employee> employees = repo.findByAddress(address);
	        if (!employees.isEmpty()) {
	            repo.deleteAll(employees);
	            return "Deleted Successfully";
	        } else {
	            return "Employees with address " + address + " not found";
	        }
	    }
	


}

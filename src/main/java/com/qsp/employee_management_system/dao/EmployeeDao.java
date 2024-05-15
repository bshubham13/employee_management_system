package com.qsp.employee_management_system.dao;

import java.util.List;

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

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);

	}

	public List<Employee> saveEmployees(@RequestBody List<Employee> list) {
		return repo.saveAll(list);
	}

	public Employee findEmployee(long phone) {
		return repo.findByPhone(phone);
	}

	public Employee findEmployee(String email) {
		return repo.getByEmail(email);
	}

	public Employee getEmployee(String userName) {
		try {
			long phone = Long.parseLong(userName);
			return findEmployee(phone);
		} catch (Exception e) {
			String email = userName;
			return findEmployee(email);
		}
	}

}

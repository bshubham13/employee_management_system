package com.qsp.employee_management_system.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="employee_info")
public class Employee { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="EmployeeId")
	private int id;
	@Column(name="EmployeeName")
	private String name;
	@Column(name="EmployeePhone",unique=true)
	private long phone;
	@Column(name="EmployeeAddress")
	private String address;
	@Column(name="EmployeeEmail",unique=true)
	private String email;
	@Column(name="EmployeePassword")
	private String password;
	@Column(name="EmployeeSalary")
	private double salary;
	@Column(name="EmployeeDesignation")
	private String designation;
	@Column(name="EmployeeGrade")
	private char grade;
	

}
package com.lpu.boot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lpu.boot2.entity.Employee;
import com.lpu.boot2.repository.EmployeeRespository;

@Repository
public class EmployeeService {
	
	@Autowired
	private EmployeeRespository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}
	
	public Employee findEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public List<Employee> findEmployeeByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Employee> findEmployeeByDepartment(String department) {
		return repository.findByDepartment(department);
	}
	
	public Employee findEmployeeByPhone(long phone) {
		return repository.findByPhone(phone);
	}
	
	public Employee findEmployeeByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Employee updateEmployeeId(int id, Employee employee) {
		repository.findById(id).orElse(null);
		return repository.save(employee);
	}
	
	public List<Employee> getEmployeesBtwSalary(){
		return repository.getEmployeeBtwSal();
	}
	
	public Employee getMaxSalaryEmployee(){
	    return repository.findMaxSalaryEmployee();
	}

	public Employee getMinSalaryEmployee(){
	    return repository.findMinSalaryEmployee();
	}

	public List<Employee> getEmployeesByDeptAndSalary(String dept, int sal){
	    return repository.findByDepartmentAndSalaryGreaterThan(dept, sal);
	}
}

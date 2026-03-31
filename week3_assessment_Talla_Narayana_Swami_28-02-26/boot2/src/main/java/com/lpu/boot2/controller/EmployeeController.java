package com.lpu.boot2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot2.entity.Employee;
import com.lpu.boot2.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	public Employee saveEmp(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}

	@GetMapping("/employees")
	public List<Employee> findAllEmp() {
		return service.findAllEmployees();
	}

	@GetMapping("/employee")
	public Employee findEmpById(@RequestParam int id) {
		return service.findEmployeeById(id);
	}

	@DeleteMapping("/employees")
	public String deleteEmpById(@RequestParam int id) {
		service.deleteEmployeeById(id);
		return "Employee with id " + id + "deleted";
	}

	@GetMapping("/employees/search")
	public List<Employee> findEmpByName(@RequestParam String name) {
		return service.findEmployeeByName(name);
	}

	@GetMapping("/employees/search1")
	public List<Employee> findEmpByDept(@RequestParam String department) {
		return service.findEmployeeByDepartment(department);
	}

	@GetMapping("/employees/search2")
	public Employee findEmployeeByPhone(@RequestParam long phone) {
		return service.findEmployeeByPhone(phone);
	}

	@GetMapping("/employees/search3")
	public Employee findEmployeeByEmail(@RequestParam String email) {
		return service.findEmployeeByEmail(email);
	}

	@PutMapping("/employees")
	public Employee updateEmpById(@RequestParam int id, @RequestBody Employee emp) {
		return service.updateEmployeeId(id, emp);
	}

	@GetMapping(value = "/employees/search4")
	public List<Employee> getEmployeesBetweenSalary() {

		return service.getEmployeesBtwSalary();
	}

	@GetMapping("/employees/max-salary")
	public Employee getMaxSalaryEmployee() {
		return service.getMaxSalaryEmployee();
	}

	@GetMapping("/employees/min-salary")
	public Employee getMinSalaryEmployee() {
		return service.getMinSalaryEmployee();
	}

	// /api/employees/search?department=Testing&salary=50000
	@GetMapping(value = "/employees/search")
	public List<Employee> getTestingDeptEmployees(@RequestParam String department, @RequestParam int salary) {
		return service.getEmployeesByDeptAndSalary(department, salary);
	}
}

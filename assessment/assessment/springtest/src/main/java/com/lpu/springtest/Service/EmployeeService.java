package com.lpu.springtest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.springtest.Repository.EmployeeRepo;
import com.lpu.springtest.entity.Employee;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo emprepo;
	
	//add emp
	public Employee addemp(Employee emp) {
		return emprepo.save(emp);
	}
	
	
	public List<Employee> fetcAllEmp(){
		return emprepo.findAll();
	}
	
	public Employee finbyId(int id) {
		return emprepo.findById(id).orElse(null);
	}
	
	//delete
	public void deletebyID(int id) {
		emprepo.deleteById(id);
	}
	
	//getemployeebyname
	public List<Employee> getEmpName(String name){
		return emprepo.getByName(name);
	}
	
	public List<Employee> getEmpDep(String department){
		return emprepo.getByDepartment(department);
	}
	
	//by phone
	public Employee getEmpPhn(long phone) {
		return emprepo.getByPhone(phone);
	}
	
	
	//by email
	public Employee getEmpEmail(String email) {
		return emprepo.getByEmail(email);
	}
	
	//update emp
	public Employee updateEmp(Employee employee) {
		return emprepo.save(employee);
	}
	
	
	//sal between
	public List<Employee> findSalBetween(double min,double max){
		return emprepo.findBySalaryBetween(min, max);
	}
	
	//min sal
	public Employee findMinSal() {
		return emprepo.findmin();
	}
	
	//max sal
	public Employee finMaxSal() {
		return emprepo.findmax();
	}
	//dpet and sal
	public List<Employee> findSalAndDept(double salary,String department){
		return emprepo.findBySalaryAndDept(department, salary);
	}

}

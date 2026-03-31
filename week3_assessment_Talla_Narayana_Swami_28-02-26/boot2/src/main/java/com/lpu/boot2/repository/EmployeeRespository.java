package com.lpu.boot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.boot2.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByName(String name);
	
	List<Employee> findByDepartment(String department);
	
	Employee findByPhone(long phone);
	
	Employee findByEmail(String email);
	
	@Query("select e from Employee e where e.salary >= 30000 and e.salary <= 60000")
	List<Employee> getEmployeeBtwSal();
	
	@Query("select e from Employee e where e.salary = (select max(e.salary) from Employee e)")
	Employee findMaxSalaryEmployee();
	
	@Query("select e from Employee e where e.salary = (select min(e.salary) from Employee e)")
	Employee findMinSalaryEmployee();
	
	List<Employee> findByDepartmentAndSalaryGreaterThan(
	        String department, int salary);
}

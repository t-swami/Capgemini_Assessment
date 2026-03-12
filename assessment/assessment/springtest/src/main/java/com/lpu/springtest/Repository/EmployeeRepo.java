package com.lpu.springtest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.springtest.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	
	//Custom methods 
	List<Employee> getByName(String name);
	List<Employee> getByDepartment(String department);
	Employee getByPhone(long phone);
	Employee getByEmail(String email);
	
	//custom Query
	@Query(value = "SELECT * FROM Employee WHERE salary BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Employee> findBySalaryBetween(double min, double max);
	
	@Query(nativeQuery=true, value="select * from Employee where salary =(select MIN(salary) from Employee)")
	Employee findmin();
	
	@Query(nativeQuery=true, value="select * from Employee where salary =(select MAX(salary) from Employee)")
	Employee findmax();
	
	@Query(value = "SELECT * FROM Employee WHERE department = :department AND salary >= :salary", nativeQuery = true)
	List<Employee> findBySalaryAndDept(String department,double salary);

}

package com.lpu.springtest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.springtest.Service.EmployeeService;
import com.lpu.springtest.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService empservice;
	
	//saveemp
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee emp) {
		return empservice.addemp(emp);
	}
	
	//fetchall
	@GetMapping("/employees/all")
	public List<Employee> fetchAll(){
		return empservice.fetcAllEmp();
	}
	
	//findById
	@GetMapping("/employees/id")
	public Employee findBYId(@RequestParam int id) {
		return empservice.finbyId(id);
	}
	//delete by id
	@DeleteMapping("/employees/deleteid")
	public void deleteBYID(@RequestParam int  id) {
		empservice.deletebyID(id);
	}
	
	//by name
	@GetMapping("/employees/search/name")
	public List<Employee> getBYNMAE(@RequestParam String  name){
		return empservice.getEmpName(name);
	}
	
	//by departmet
	
	@GetMapping("/employees/search/department/{department}")
	public List<Employee> getBYDEPT(@PathVariable String department){
		return empservice.getEmpDep(department);
	}
	
	//by phone
	
	@GetMapping("/employees/search/phone/{phone}")
	public Employee getEMPPHN(@PathVariable long phone) {
		return empservice.getEmpPhn(phone);
	}
	
	
	//by email
	@GetMapping("/employees/search/email/{email}")
	public Employee getEMPEMAIL(@PathVariable String email) {
		return empservice.getEmpEmail(email);
	}
	
	//update employee
	@PutMapping("/employees/update")
	public Employee updateEMP(@RequestBody Employee employee) {
		return empservice.updateEmp(employee);
	}
	
	/////=================================================
	//sal between min and max
	@GetMapping("/employees/find/minmax")
	public List<Employee> findBYMINANDMAX(@RequestParam double min,@RequestParam double max){
		return empservice.findSalBetween(min, max);
	}
	
	
	@GetMapping("/employees/find/min")
	public Employee findMINSAL() {
		return empservice.findMinSal();
	}
	
	//max sal
	@GetMapping("/employees/find/max")
	public Employee findMAXSAL() {
		return empservice.finMaxSal();
	}
	
	//dept and sal
	@GetMapping("/employees/find/saldept")
	public List<Employee> findSALDEPT(@RequestParam double salary,@RequestParam String department){
		return empservice.findSalAndDept(salary, department);
	}
	
	
	
	
	
	

}

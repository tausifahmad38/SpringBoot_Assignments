package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;

import jakarta.annotation.PostConstruct;

@RestController
public class EmployeeController {
	
	private Map<Integer,Employee> mp=new HashMap<Integer,Employee>();
	
	@GetMapping("/displayAll")
	public Map<Integer,Employee> getAllEmployee(){
		return mp;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		if(mp.containsKey(empId)) {
			return mp.get(empId);
		}else {
			System.out.println("Employee with ID "+empId+" Does not Exist !!");
			return null;
		}
		
	}
	
	@PostMapping("/employee/save")
	public String saveEmployee(@RequestBody Employee e) {
		if(mp.containsKey(e.getEmpId())) {
			return "Employee with ID "+e.getEmpId()+" already exist !!";
		}else {
			mp.put(e.getEmpId(), e);
			return "Employee Saved successfully...";
		}
		
	}
	
	@PutMapping("/employee/update/{id}")
	public String saveEmployee(@PathVariable("id") int empId, @RequestBody Employee e) {
		
		if(empId !=e.getEmpId()) {
			return "Given ID didn't match with employee Id";
		}
		
		if(mp.containsKey(e.getEmpId())) {
			
			Employee emp=mp.get(empId);
			emp.setEmail(e.getEmail());
			emp.setName(e.getName());
			emp.setLocation(e.getLocation());
			mp.put(empId, emp);
			
			return "Employee details Updated !!";
		}else {
			
			return "Employee with ID "+empId+" Does not Exist !!";
		}
		
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public String saveEmployee(@PathVariable("id") int empId) {
		if(mp.containsKey(empId)) {
			
			mp.remove(empId);
			
			return "Employee with ID "+empId+" Deleted Successfully !!";
		}else {
			
			return "Employee with ID "+empId+" Does not Exist !!";
		}
		
	}
	
	@PostConstruct
	public void initializeEmployee() {
		Employee e1=new Employee(1,"ABC","abc@gmail.com","Noida");
		Employee e2=new Employee(2,"XYZ","xyz@gmail.com","Delhi");
		Employee e3=new Employee(3,"PQR","pqr@gmail.com","Patna");
		mp.put(e1.getEmpId(), e1);
		mp.put(e2.getEmpId(), e2);
		mp.put(e3.getEmpId(), e3);
	}

}

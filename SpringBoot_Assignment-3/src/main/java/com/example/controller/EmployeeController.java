package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repo;

	@GetMapping("/displayAll")
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		Employee emp = repo.findByEmpId(empId);
		if (emp != null) {
			return emp;
		} else {
			System.out.println("Employee with ID " + empId + " Does not Exist !!");
			return null;
		}
	}

	@PostMapping("/employee/save")
	public String saveEmployee(@RequestBody Employee e) {
		Employee emp = repo.findByEmail(e.getEmail());
		if (emp != null) {
			return "Employee with email " + e.getEmail() + " already exist !!";
		} else {
			repo.save(e);
			return "Employee Saved successfully...";
		}
	}

	@PutMapping("/employee/update/{id}")
	public String saveEmployee(@PathVariable("id") int empId, @RequestBody Employee e) {
		
		if (empId != e.getEmpId()) {
			return "Given ID didn't match with employee Id";
		} else {
			Employee emp = repo.findByEmpId(e.getEmpId());
			if (emp != null) {
				emp.setEmail(e.getEmail());
				emp.setName(e.getName());
				emp.setLocation(e.getLocation());
				repo.save(emp);
				return "Employee details Updated !!";
			} else {
				return "Employee with ID " + empId + " Does not Exist !!";
			}
		}
	}

	@DeleteMapping("/employee/delete/{id}")
	public String saveEmployee(@PathVariable("id") int empId) {
		Employee emp = repo.findByEmpId(empId);
		if (emp != null) {
			repo.delete(emp);
			return "Employee with ID " + empId + " Deleted Successfully !!";
		} else {

			return "Employee with ID " + empId + " Does not Exist !!";
		}
	}
}

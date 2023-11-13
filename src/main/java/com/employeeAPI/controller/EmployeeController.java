package com.employeeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeAPI.entities.Employee;
import com.employeeAPI.service.EmployeeService;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//save endpoint
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	//get all the records endpoint
	@GetMapping("/findAll")
	public List<Employee> findAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	//get specific record endpoint
	@GetMapping("/findEmployeeById/{id}")
	public Employee findEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeById(id);
	}
	
	//update specific record endpoint
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	//delete specific record endpoint
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
}

package com.employeeAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeeAPI.entities.Employee;
import com.employeeAPI.repository.IEmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepo;
	
	public Employee saveEmployee(Employee temp) {
		Employee employee = new Employee();
		String name = temp.getName();
		String email = temp.getEmail();
		Long phone = temp.getPhone();
		String created_by = temp.getCreated_by();
		//field validation
		if(!(name == null || email == null || phone == null || created_by == null)) {
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			employee.setCreated_by(created_by);
			return employeeRepo.save(employee);
		}
		return null;
	}
	
	public Employee findEmployeeById(Long id) {
		if(employeeRepo.existsById(id)) {
			return employeeRepo.findById(id).get();
		}
		return null;
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Long id, Employee temp){
		if(employeeRepo.existsById(id)) {
			//fetch record and save
			Employee employee = employeeRepo.findById(id).get();
			employee.setName(temp.getName());
			employee.setEmail(temp.getEmail());
			employee.setPhone(temp.getPhone());
			employee.setCreated_by(temp.getCreated_by());
			
			return employeeRepo.save(employee);
		}
		return null;
	}
	
    public String deleteEmployee(Long id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return "Deleted";
        } else {
            return "Employee with the given id is not found";
        }
    }
}

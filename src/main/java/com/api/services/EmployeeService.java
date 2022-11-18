package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.dao.EmployeeRepository;
import com.api.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	// save a employee details
	public Employee saveEmployee(Employee emp) {
		this.repository.save(emp);
		return emp;
	}

	// get list all the employee
	public List<Employee> getAllEmployee(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Employee> pageEmployee = this.repository.findAll(p);
		List<Employee> emp = pageEmployee.getContent();
		return emp;
	}

	// delete the employee details from db
	public void deleteEmployee(int id) {
		this.repository.deleteById(id);
	}

	// update the employee details
	public void updateEmployee(Employee emp, int id) {
		emp.setEmpId(id);
		this.repository.save(emp);
	}

	// get Employee Details By ID
	public Employee getEmployeeById(int id) {
		Employee emp = this.repository.findById(id);
		return emp;
	}

	// get Employee Details By Name
	public Employee getEmployeeByName(String name) {
		Employee emp = this.repository.findByName(name);
		return emp;
	}
}
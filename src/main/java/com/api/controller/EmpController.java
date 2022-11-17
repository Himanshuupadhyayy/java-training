package com.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Employee;
import com.api.services.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService service;

	// for save data into db
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
		Employee empp = null;
		try {
			empp = this.service.saveEmployee(emp);
			return ResponseEntity.of(Optional.of(empp));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// get all the employee details
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
		List<Employee> emp = this.service.getAllEmployee(pageNumber, pageSize, sortBy, sortDir);
		if (emp.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}

	// delete a employee details
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
		try {
			this.service.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// for update the details of employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		try {
			this.service.updateEmployee(emp, id);
			return ResponseEntity.ok().body(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// get student details by using the id
	@GetMapping("/employe/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		Employee emp = this.service.getEmployeeById(id);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}

	@GetMapping("/empName/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) {
		Employee emp =  this.service.getEmployeeByName(name);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}
}
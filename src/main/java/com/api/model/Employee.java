package com.api.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int EmpId;

	@Size(min = 4, message = "name must be at least 4 chars !!")
	@NotEmpty // means having a character minimum
	private String name;
	@NotBlank(message = "please enter the Dateof Birth") // not accept empty
	private String dateOfBirth;
	@Email
	private String email; // accept null
//	@Column(columnDefinition = "male")
	private String gender = "male";
	@NotEmpty
	@Size(min = 10)
	private String address;
	private String phone;

	@CreationTimestamp
	@Column(name = "create_At", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime CreateTimeStamp;

	@UpdateTimestamp
	@Column(name = "Update_At", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime UpdateTimeStamp;

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreateTimeStamp() {
		return CreateTimeStamp;
	}

	public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
		CreateTimeStamp = createTimeStamp;
	}

	public LocalDateTime getUpdateTimeStamp() {
		return UpdateTimeStamp;
	}

	public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
		UpdateTimeStamp = updateTimeStamp;
	}
}
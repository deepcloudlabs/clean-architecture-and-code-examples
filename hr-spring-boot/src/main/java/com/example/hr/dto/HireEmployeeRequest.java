package com.example.hr.dto;

import com.example.hr.entity.Department;
import com.example.hr.entity.Employee;
import com.example.hr.entity.MoneyCurrency;
import com.example.validation.IbanNo;
import com.example.validation.KimlikNo;

// JSON
public class HireEmployeeRequest {
	@KimlikNo
	private String identity;
	private String firstName;
	private String lastName;
	@IbanNo
	private String iban;
	private double salary;
	private int birthYear;
	private String department;
	private boolean fulltime;
	private String photo;
	
	public HireEmployeeRequest() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Employee toEmployee() {
		return new Employee.Builder(identity)
				                .department(Department.valueOf(department))
				                .birthYear(birthYear)
				                .fullname(firstName, lastName)
				                .fulltime(fulltime)
				                .photo(photo.getBytes())
				                .salary(salary, MoneyCurrency.TL)
				                .build();
	}
	


}

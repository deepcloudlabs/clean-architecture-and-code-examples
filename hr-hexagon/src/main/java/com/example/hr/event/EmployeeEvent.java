package com.example.hr.event;

import com.example.hr.entity.Employee;

public class EmployeeEvent {
	private final Employee employee;
	
	public EmployeeEvent(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}
}

package com.example.hr.event;

import com.example.hr.entity.Employee;

public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent(Employee employee) {
		super(employee);
	}

}

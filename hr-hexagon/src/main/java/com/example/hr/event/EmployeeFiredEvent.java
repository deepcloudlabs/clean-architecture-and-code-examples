package com.example.hr.event;

import com.example.hr.entity.Employee;

public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent(Employee employee) {
		super(employee);
	}

}

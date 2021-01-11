package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.entity.Employee;
import com.example.hr.entity.TcKimlikNo;
import com.example.hr.event.EmployeeEvent;
import com.example.hr.event.EmployeeFiredEvent;
import com.example.hr.event.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	// dependencies: EmployeeRepository, EventPublisher
	private EmployeeRepository employeeRepository;
	private EventPublisher<EmployeeEvent> eventPublisher;
	
	// DIP: constructor injection
	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher<EmployeeEvent> eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	// EmployeeHiredEvent : i. Business Event ii. Past
	@Override
	public void hireEmployee(Employee employee) {
		var emp = employeeRepository.findByIdentity(employee.getIdentityNo());
		if (emp.isPresent())
			throw new IllegalArgumentException("Employee already exists.");
		employeeRepository.save(employee);
		eventPublisher.publishEvent(new EmployeeHiredEvent(employee));
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo kimlik) {
		var emp = employeeRepository.findByIdentity(kimlik);
		if (emp.isEmpty())
			return emp;
		var employee = emp.get();
		employeeRepository.remove(employee);
		eventPublisher.publishEvent(new EmployeeFiredEvent(employee));
		return emp;
	}

}

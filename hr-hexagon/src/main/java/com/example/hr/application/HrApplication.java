package com.example.hr.application;

import java.util.Optional;

import com.example.hr.entity.Employee;
import com.example.hr.entity.TcKimlikNo;

public interface HrApplication {
	void hireEmployee(Employee employee);
	Optional<Employee> fireEmployee(TcKimlikNo kimlik);
}

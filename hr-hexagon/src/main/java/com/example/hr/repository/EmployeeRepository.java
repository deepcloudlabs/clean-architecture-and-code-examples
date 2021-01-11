package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.entity.Employee;
import com.example.hr.entity.TcKimlikNo;

public interface EmployeeRepository {

	Optional<Employee> findByIdentity(TcKimlikNo tcKimlikNo);

	void save(Employee employee);

	void remove(Employee employee);

}

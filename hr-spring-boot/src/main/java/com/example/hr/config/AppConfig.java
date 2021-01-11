package com.example.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.adapter.EventPublisherMultipleAdapter;
import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {

	@Bean
	public HrApplication hrApp(EmployeeRepository employeeRepository, 
			EventPublisherMultipleAdapter eventPublisher) {
		return new StandardHrApplication(employeeRepository, eventPublisher);
	}
}

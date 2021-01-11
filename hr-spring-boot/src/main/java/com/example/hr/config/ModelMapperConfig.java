package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.entity.Employee;
import com.example.hr.entity.FullName;
import com.example.hr.entity.MoneyCurrency;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Configuration
public class ModelMapperConfig {
	private static final Converter<EmployeeDocument, Employee> employeeDocumentToEmployeeConverter = context -> {
		var employeeDocument = context.getSource();
		String[] tokens = employeeDocument.getFullname().split("\\w+");
		return new Employee.Builder(employeeDocument.getIdentity()).fullname(tokens[0], tokens[1])
				.iban(employeeDocument.getIban()).salary(employeeDocument.getSalary(), MoneyCurrency.TL)
				.birthYear(employeeDocument.getBirthYear()).fulltime(employeeDocument.getFulltime())
				.department(employeeDocument.getDepartment()).photo(employeeDocument.getPhoto().getBytes()).build();
	};
	private static final Converter<Employee, EmployeeDocument> employeeToEmployeeDocumentConverter = (context -> {
		var employee = context.getSource();
		EmployeeDocument employeeDocument = new EmployeeDocument();
		employeeDocument.setIdentity(employee.getIdentityNo().getValue());
		FullName fullname = employee.getFullname();
		employeeDocument.setFullname(fullname.getFirst() + " " + fullname.getLast());
		employeeDocument.setSalary(employee.getSalary().getValue());
		employeeDocument.setIban(employee.getIban().getValue());
		employeeDocument.setPhoto(new String(employee.getPhoto().getValue()));
		employeeDocument.setBirthYear(employee.getBirthYear().getValue());
		employeeDocument.setDepartment(employee.getDepartment());
		employeeDocument.setFulltime(employee.isFulltime());
		return employeeDocument;
	});


	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addConverter(employeeToEmployeeDocumentConverter, Employee.class, EmployeeDocument.class);
		mapper.addConverter(employeeDocumentToEmployeeConverter, EmployeeDocument.class, Employee.class);
		return mapper;
	}
}

package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.entity.Employee;
import com.example.hr.entity.FullName;
import com.example.hr.entity.TcKimlikNo;
import com.example.hr.repository.EmployeeMongoRepository;
import com.example.hr.repository.EmployeeRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Repository
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeMongoRepository empRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		Optional<EmployeeDocument> empDoc = empRepo.findById(identity.getValue());
		if (!empDoc.isEmpty())
			return Optional.empty();
		Employee employee = mapper.map(empDoc.get(), Employee.class);
		return Optional.of(employee);
	}

	@Override
	public void save(Employee employee) {
		// EmployeeDocument empDoc= mapper.map(employee, EmployeeDocument.class);
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
		empRepo.save(employeeDocument);
	}

	@Override
	public void remove(Employee employee) {
		empRepo.deleteById(employee.getIdentityNo().getValue());
	}

}

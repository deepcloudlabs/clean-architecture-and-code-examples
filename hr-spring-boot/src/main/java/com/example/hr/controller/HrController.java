package com.example.hr.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.application.HrApplication;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.entity.TcKimlikNo;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/employees")
// Adapter: HTTP -> method
public class HrController {
	private HrApplication hrApplication;

	public HrController(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}

	@GetMapping("{identity}")
	@Cacheable(value = "employees", key = "#identity")
	public EmployeeDocument getEmployee(@PathVariable("identity") String identity) {
		return null;
	}
	
	// HTTP POST /employees --> HrApplication::hireEmployee
	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody @Validated HireEmployeeRequest request) {
		hrApplication.hireEmployee(request.toEmployee());
		return new HireEmployeeResponse("success");
	}

	// HTTP DELETE /employees/11111111110 --> HrApplication::fireEmployee
	@DeleteMapping("{identity}")
	@CacheEvict(value = "employees", key = "#identity")
	public FireEmployeeResponse fireEmployee(@PathVariable("identity") String identity) {
		var employee = hrApplication.fireEmployee(TcKimlikNo.of(identity));
		if (employee.isEmpty())
			return new FireEmployeeResponse("fail");
		return new FireEmployeeResponse("success");
	}

}

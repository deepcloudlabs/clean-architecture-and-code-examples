package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.entity.Department;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface EmployeeMongoRepository extends MongoRepository<EmployeeDocument, String> {
	List<EmployeeDocument> findAllByBirthYearBetweenAndDepartment(int fromYear, int toYear, Department department);

	@Query(value = "{'birthYear': {'$gt': ?0, '$lt': ?1}}")
	List<EmployeeDocument> araBul(int fromYear, int toYear);

}

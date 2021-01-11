package com.example.hr.document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

import com.example.hr.entity.Department;
import com.example.validation.IbanNo;
import com.example.validation.KimlikNo;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Document(collection = "employees")
@Sharded(shardKey = "identity", immutableKey = true)
public class EmployeeDocument {
	@KimlikNo
	@Id
	private String identity;
	@Size(min = 5)
	private String fullname;
	@Min(3_000)
	private Double salary;
	@IbanNo
	private String iban;
	private Boolean fulltime;
	@Max(2002)
	private int birthYear;
	private String photo;
	private Department department;

	public EmployeeDocument() {
	}

	public EmployeeDocument(String identity, @Size(min = 5) String fullname, @Min(3000) Double salary, String iban,
			Boolean fulltime, @Max(2002) int birthYear, Department department) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.fulltime = fulltime;
		this.birthYear = birthYear;
		this.department = department;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Boolean getFulltime() {
		return fulltime;
	}

	public void setFulltime(Boolean fulltime) {
		this.fulltime = fulltime;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDocument other = (EmployeeDocument) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDocument [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", iban="
				+ iban + ", fulltime=" + fulltime + ", birthYear=" + birthYear + ", department=" + department + "]";
	}

}

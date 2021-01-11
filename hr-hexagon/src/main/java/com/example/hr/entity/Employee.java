package com.example.hr.entity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// DDD : Core Domain -> Entity Root -> Aggregate
// Ubiquitous Language: Entity, Entity Root/Aggregate/Value Object 
// Bounded Context <--> Sub Domain
// Shortcuts (Eclipse)                     IntelliJ IDEA  
// Ctrl + Shift + + (Zoom In)              (Ctrl + Mouse Wheel)
// Ctrl + - (Zoom Out)                     (Ctrl + Mouse Wheel)
// Ctrl + 1 (Suggestion to remove errors)  (Alt + Enter)
// Alt + Shift + S (Generate Source Code)  (Alt + Insert)
// Ctrl + Shift + F (Format Source Code)   (Ctrl + Alt + L)
public class Employee {
	private static final Money MIN_SALARY = Money.of(3_000, MoneyCurrency.TL);
	private TcKimlikNo identityNo;
	private FullName fullname;
	private Money salary;
	private Iban iban;
	private BirthYear birthYear;
	private Photo photo;
	private boolean fulltime;
	private Department department;

	public Employee() {
	}

	public Employee(TcKimlikNo identityNo, FullName fullname, Money salary, Iban iban, BirthYear birthYear, Photo photo,
			boolean fulltime, Department department) {
		this.identityNo = identityNo;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.birthYear = birthYear;
		this.photo = photo;
		this.fulltime = fulltime;
		this.department = department;
	}

	private Employee(Builder builder) {
		this.identityNo = builder.identityNo;
		this.fullname = builder.fullname;
		this.salary = builder.salary;
		this.iban = builder.iban;
		this.birthYear = builder.birthYear;
		this.photo = builder.photo;
		this.fulltime = builder.fulltime;
		this.department = builder.department;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public TcKimlikNo getIdentityNo() {
		return identityNo;
	}

	public Money getSalary() {
		return salary;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void increaseSalary(double percentage) {
		if (percentage <= 0.)
			throw new IllegalArgumentException("Percentage cannot be negative or zero");
		this.salary = this.salary.multiply(1. + percentage);
	}

	public void decreaseSalary(double percentage) {
		if (percentage <= 0.)
			throw new IllegalArgumentException("Percentage cannot be negative or zero");
		this.salary = this.salary.multiply(1. - percentage);
		if (this.salary.lessThan(MIN_SALARY))
			this.salary = MIN_SALARY;
	}

	public void hireToFulltime() {
		if (this.fulltime)
			throw new IllegalArgumentException("Already full-time");
		this.fulltime = true;
		this.increaseSalary(50.);
	}

	public void hireToParttime() {
		if (!this.fulltime)
			throw new IllegalArgumentException("Already part-time");
		this.fulltime = false;
		this.decreaseSalary(50.);
	}

	@Override
	public String toString() {
		return "Employee [identityNo=" + identityNo + ", fullname=" + fullname + ", salary=" + salary + ", iban=" + iban
				+ ", birthYear=" + birthYear + ", fulltime=" + fulltime + ", department=" + department + "]";
	}

	public static class Builder {
		private final TcKimlikNo identityNo;
		private FullName fullname;
		private Money salary;
		private Iban iban;
		private BirthYear birthYear;
		private Photo photo;
		private boolean fulltime;
		private Department department;

		public Builder(String identityNo) {
			this.identityNo = TcKimlikNo.of(identityNo);
		}

		public Builder fullname(String firstName, String lastName) {
			this.fullname = new FullName(firstName, lastName);
			return this;
		}

		public Builder salary(double value, MoneyCurrency currency) {
			this.salary = Money.of(value, currency);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = BirthYear.of(value);
			return this;
		}

		public Builder photo(byte[] value) {
			this.photo = Photo.of(value);
			return this;
		}

		public Builder fulltime(boolean fulltime) {
			this.fulltime = fulltime;
			return this;
		}

		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}
}

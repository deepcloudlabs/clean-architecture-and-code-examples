package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class HowToAvoidLoopsAndIfStatements {

	public static void main(String[] args) {
		// var: Java 10
		var customers = List.of( // Java 9 --> Immutable List, Factory Method
			new Customer("1", "jack bauer", "jack.bauer@example.com", 1956),
			new Customer("2", "jack shephard", "jack.shephard@example.org", 1975),
			new Customer("3", "kate austen", "kate.austen@example.com", 1984),
			new Customer("4", "jin kwon", "jin.kwon@example.org", 1986)
		);
		var customersBornAfter1980 = new ArrayList<Customer>();
		for (var customer : customers) {
			if(customer.getBirthYear()>1980)
				customersBornAfter1980.add(customer);
		}
		for (var customer : customersBornAfter1980)
			System.out.println(customer.getFullname());
		Predicate<Customer> bornAfter1980 = customer -> customer.getBirthYear() > 1980;
		Predicate<Customer> worksAtOrg = customer -> customer.getEmail().endsWith("org");
		Comparator<Customer> orderByAge = (first,second) -> first.getBirthYear()-second.getBirthYear();
		// DSL: Domain Specific Language -> Naming -> 
		var customersOfCampaign = customers.parallelStream() 
				    // Iterator -> Spliterator -> Parallel -> ForkJoin Framework (Java SE 7) -> ForkJoin Pool
				                           //.filter(bornAfter1980)
										   .filter(worksAtOrg)
										   // Big Data/Deep Learning -> GPU + CPU
										   //.parallel() // over use? Size > ? CPU (24) -> GPU (RTX 3090)
						                   .sorted(orderByAge.reversed())
						                   .collect(Collectors.toList());
		
		customersOfCampaign.forEach(System.out::println);
	}

}

class Customer {
	private String identity;
	private String fullname;
	private String email;
	private int birthYear;

	public Customer() {
	}

	public Customer(String identity, String fullname, String email, int birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.email = email;
		this.birthYear = birthYear;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
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
		Customer other = (Customer) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + ", email=" + email + ", birthYear="
				+ birthYear + "]";
	}

}
package com.example;

public class Naming1 {

	public static void main(String[] args) {
		int d; // concept?
		long day;
		day = 12345 + 5432L; // l character -> L
		System.out.println("day: " + day);

		int dom;
		int dayOfMonth;
		int i_day_of_month; // _ -> operator
		int x = 0, y = 0, z;
		z = x++ + ++y; //
		// use the following
		y = y + 1;
		z = x + y;
		x = x + 1;
        // Naming -> Camel Notation
		AccountService acc;
		
	}
	
}

enum EmployeeStatus {
	FULL_TIME, PART_TIME
}

interface EmployeeStatus2 {
	public static final int FULL_TIME = 1;
	int PART_TIME = 2;
}

class Employee {
	public static final int FULL_TIME = 1;
	public static final int PART_TIME = 2;
	
}
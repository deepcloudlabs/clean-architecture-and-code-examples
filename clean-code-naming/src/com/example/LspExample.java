package com.example;

public class LspExample {
	public static void processAccount(IAccount acc) {
		A a = new C();
		System.out.println(a instanceof C);
		System.out.println(a instanceof IAccount);
	}
	public static void main(String[] args) {
        processAccount(new CheckingAccount()); // works fine
        //processAccount(new SavingsAccount());
	}
}

abstract interface IAccount {
	default public void deposit(double amount) {}; // Java 8+
	default public void withdraw(double amount) { sun();}; // Java 8+
	static public int fun() { return gun();} // Java 8+ => Functional Programming => Utility
	static private int gun() { return 42;} // Java 9+ // DRY
	private int sun() { return 108;} // Java 9+ // DRY
}

class CheckingAccount implements IAccount{}
class SavingsAccount implements IAccount{ }

class A {}
class B extends A {}
class C extends B {}
class D {}
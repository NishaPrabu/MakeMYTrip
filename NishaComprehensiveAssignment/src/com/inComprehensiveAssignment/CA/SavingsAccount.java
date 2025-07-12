package com.inComprehensiveAssignment.CA;

//Derived Class
public class SavingsAccount extends Account {

	public SavingsAccount(double interestRate, double balance) {
		super(interestRate, balance);
	}

	@Override
	public void calculateInterest() {

		double interest = balance * interestRate / 100;
		balance += interest;
		System.out.println("Savings Account with Interest added: " + interest);
	}

}

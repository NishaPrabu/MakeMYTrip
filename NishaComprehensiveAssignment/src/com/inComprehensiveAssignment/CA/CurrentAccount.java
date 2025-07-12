package com.inComprehensiveAssignment.CA;

//Derived Class
public class CurrentAccount extends Account {

	public CurrentAccount(double interestRate, double balance) {
		super(interestRate, balance);
	}

	@Override
	public void calculateInterest() {
		double interest = balance * interestRate / 100;
		balance += interest;
		System.out.println("CurrentAccount with Interest added: " + interest);
	}

}

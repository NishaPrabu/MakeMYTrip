package com.inComprehensiveAssignment.CA;

//base class
public class Account {

	protected double interestRate;
	protected double balance;

	public Account(double interestRate, double balance) {
		this.interestRate = interestRate;
		this.balance = balance;
	}

	public void calculateInterest() {
		double Interest = balance * interestRate / 100;
		balance += Interest;
		System.out.println("Added Interest " + Interest);
	}

	public void AddToAccount() {
		System.out.println("After Adding Interest to balance " + balance);
	}

}

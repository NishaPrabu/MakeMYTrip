package com.inComprehensiveAssignment.CA;

public class TypeAccount {

	public static void main(String[] args) {

		SavingsAccount savings = new SavingsAccount(7, 10000);
		CurrentAccount current = new CurrentAccount(4, 40000);

		System.out.println("=== Savings Account ===");
		savings.calculateInterest();
		savings.AddToAccount();

		System.out.println("\n=== Current Account ===");
		current.calculateInterest();
		current.AddToAccount();
	}

}

package com.inSDET.nishaSDET;

public class MultiplicationTable
{
	void printMultiplication() {
		printMultiplication(4);

		/*
		 * for(int i = 1; i<=10; i++) { System.out.printf("%d X %d= %d", 4, i, 4 * i); }
		 */
	}

void printMultiplication(int table) {
	printMultiplication(table, 1, 10);
	/*
	 * for (int i = 1; i <= 10; i++) { System.out.printf("%d X %d= %d", table, i,
	 * table * i); }
	 */
	}

	void printMultiplication(int table, int from, int to) {
		for(int i = from; i<=to; i++)
		{
			System.out.printf("%d X %d= %d", table, i, table * i);
		}
	}

}


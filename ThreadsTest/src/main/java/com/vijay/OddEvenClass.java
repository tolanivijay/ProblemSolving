package com.vijay;

public class OddEvenClass {
	
	private volatile Integer currentEven = 2;
	
	private volatile Integer currentOdd = 1;
	
	private volatile Integer currentValue = 0;

	public static void main(String[] args) {

		
		
		

	}
	
	public synchronized void printEven() {
		if (currentValue % 2 == 0) {
			return;
		}
		currentValue = currentEven;
		currentEven = currentEven + 2;
		
	}
	
	public synchronized void printOdd() {
		if (currentValue % 2 != 0) {
			return;
		}
		currentValue = currentOdd;
		currentOdd = currentOdd + 2;
	}

}

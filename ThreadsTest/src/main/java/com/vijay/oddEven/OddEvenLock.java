package com.vijay.oddEven;

public class OddEvenLock {

	private Integer currentEven = 2;
	
	private Integer currentOdd = 1;
	
	private Integer currentValue = 0;

	public Integer getCurrentEven() {
		return currentEven;
	}

	public void setCurrentEven(Integer currentEven) {
		this.currentEven = currentEven;
	}

	public Integer getCurrentOdd() {
		return currentOdd;
	}

	public void setCurrentOdd(Integer currentOdd) {
		this.currentOdd = currentOdd;
	}

	public Integer getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Integer currentValue) {
		this.currentValue = currentValue;
	}
	
	
	
}

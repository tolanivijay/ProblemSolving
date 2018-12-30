package com.vijay.oddEven;

public class OddEvenWaitNotifyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 OddEvenLock lock = new OddEvenLock();
	 printEven(lock);
	 printOdd(lock);
	}
	
	public static void printEven(OddEvenLock lock) {
		new Thread(new EvenTaskWaitNotify(lock,true)).start();
	}

	public static void printOdd(OddEvenLock lock) {
		new Thread(new EvenTaskWaitNotify(lock,false)).start();
	}
}

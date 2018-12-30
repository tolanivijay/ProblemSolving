package com.vijay.oddEven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenTest {

	public static void main(String[] args) {
		OddEvenLock lock = new OddEvenLock();
		OddTask o = new OddTask(lock);
		EvenTask e = new EvenTask(lock);
		
		ExecutorService executor=Executors.newFixedThreadPool(10);
		
		while(true) {
			executor.execute(o);
			executor.execute(e);
		}
		
		
		
	}

}

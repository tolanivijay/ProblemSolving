package com.vijay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {

	public static void main(String[] args) {
		testSemaphore();

	}
	
	private static void testSemaphore() {
		ExecutorService service = Executors.newFixedThreadPool(100);
		
		Runnable run = () ->{
			ControlledClass.getInstance().access();
		};
		
		for (int i=1;i<=100;i++) {
			service.submit(run);
		}
		
		service.shutdown();
	}

}

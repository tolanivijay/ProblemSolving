package com.vijay;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	private static CountDownLatch latch = new CountDownLatch(3);
	
	public static void main(String[] arg) {
		WorkerThread w1 = new WorkerThread(2, "Thread-1", latch);
		WorkerThread w2 = new WorkerThread(3, "Thread-2", latch);
		WorkerThread w3 = new WorkerThread(5, "Thread-3", latch);
		
		new Thread(w1).start();
		new Thread(w2).start();
		new Thread(w3).start();
		
		System.out.println("Awaiting completing of threads");
		try {
			latch.await();
		}catch(Exception e) {}
		System.out.println("CountDown completed,Do whatever you want to do man");
	}

}

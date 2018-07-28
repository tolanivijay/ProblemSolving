package com.vijay;

import java.util.concurrent.CountDownLatch;

public class WorkerThread implements Runnable{
	
	private int delay;
	
	private String name;
	
	private CountDownLatch latch;
	
	public WorkerThread(int delay,String name, CountDownLatch latch) {
		this.delay=delay*1000;
		this.name = name;
		this.latch= latch;
	}

	@Override
	public void run() {
		System.out.println(name + " sleeping for "+delay);
		try {
			Thread.sleep(delay);
		}catch (Exception e) {} 
		latch.countDown();
	}

}

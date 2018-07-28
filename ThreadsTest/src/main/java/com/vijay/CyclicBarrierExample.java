package com.vijay;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	private static CyclicBarrier barrier = new CyclicBarrier(3);
	private static CyclicBarrier barrierWithTarget  ;
	
	private static Runnable firstRun;
	private static Runnable secondRun;
	private static Runnable thirdRun;
	private static Runnable targetRun;
	
	private static void init() {
		targetRun = () ->{
			System.out.println("Called from targetRun");
		};
		barrierWithTarget = new CyclicBarrier(3, targetRun);
		firstRun = () -> {
			System.out.println("Called from first run");
			try {
				Thread.sleep(3000);
				barrierWithTarget.await();	
			}catch(Exception e) {
				
			}
			System.out.println("Await completed on first run");
		};
		secondRun = () -> {
			System.out.println("Called from secondRun");
			try {
				Thread.sleep(4000);
				barrierWithTarget.await();	
			}catch(Exception e) {
				
			}
			System.out.println("Await completed on secondRun");
		};
		thirdRun = () -> {
			System.out.println("Called from thirdRun");
			try {
				Thread.sleep(5000);
				barrierWithTarget.await();	
			}catch(Exception e) {
				
			}
			System.out.println("Await completed on thirdRun");
		};
		
	}
	
	

	public static void main(String[] args) {
		init();
		testBarrier();
	}
	
	
	private static void testBarrier() {
		Thread t1 = new Thread(firstRun);
		Thread t2 = new Thread(secondRun);
		Thread t3 = new Thread(thirdRun);
		
		t1.start();t2.start();t3.start();
	}

}
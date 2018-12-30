package com.vijay.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotifyTester {
	
	private Queue<String> sharedList = new LinkedList<String>();
	
	public static void main(String[] args) throws InterruptedException {
		WaitNotifyTester tester = new WaitNotifyTester();
		tester.startWriters();
		tester.startReaders();
		Thread.sleep(5*1000);
		System.out.println("Shared List is "+ tester.sharedList);
 	}
	
	public void startWriters() {
		Runnable write = () -> {
			synchronized (this) {
				while(true) {
					if (sharedList.size() >=5) {
						try {
							System.out.println("Waiting "+ Thread.currentThread().getName());
							this.wait();
						} catch (InterruptedException e) {
							System.out.println("Interepted on writer "+ Thread.currentThread().getName());
						}
					}else {
						sharedList.add(Thread.currentThread().getName());
						this.notifyAll();
					}
				}
			}
		};
		
		Thread t1 = new Thread(write);
		Thread t2 = new Thread(write);
		Thread t3 = new Thread(write);
		t1.setName("FirstWriter");
		t2.setName("SecondWriter");
		t3.setName("ThirdWriter");
		t1.start();t2.start();t3.start();
	}
	
	public void startReaders() {
		Runnable reads = () -> {
			while(true) {
			synchronized (this) {
				
					if (sharedList.size() <= 0) {
						try {
							System.out.println("Waiting "+ Thread.currentThread().getName());
							this.wait();
						} catch (InterruptedException e) {
							System.out.println("Interepted on reader "+ Thread.currentThread().getName());
						}
					}else {
						System.out.println("Removed "+sharedList.poll() +" and size is "+ sharedList.size());
						this.notifyAll();
					}
				}
			}
			
		};
		
		Thread t1 = new Thread(reads);
		Thread t2 = new Thread(reads);
		Thread t3 = new Thread(reads);
		t1.setName("FirstReader");
		t2.setName("SecondReader");
		t3.setName("ThirdReader");
		t1.start();t2.start();t3.start();
	}

}

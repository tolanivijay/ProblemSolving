package com.vijay;

import java.util.concurrent.Semaphore;

public class ControlledClass {
	
	private Semaphore control = new Semaphore(4);
	
	private static ControlledClass myClass = new ControlledClass();
	
	private ControlledClass() {
		
	}
	
	public static ControlledClass getInstance() {
		return myClass;
	}
	
	public void access() {
		try {
			control.acquire();
			System.out.println("Performing logic");
			Thread.sleep(1000);
		}catch(Exception e) {}
		finally {
			control.release();
		}
	}

}

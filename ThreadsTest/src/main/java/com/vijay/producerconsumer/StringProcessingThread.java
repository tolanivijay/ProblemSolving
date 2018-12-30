package com.vijay.producerconsumer;

public class StringProcessingThread implements Runnable {
	
	private String str;
	
	public StringProcessingThread(String st) {
		this.str=st;
	}
	
	public void run() {
		System.out.println("Processed "+ str + "by "+ Thread.currentThread().getName());
	}


}

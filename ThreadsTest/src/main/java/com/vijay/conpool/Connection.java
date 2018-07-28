package com.vijay.conpool;

public class Connection {
	
	private String name;
	
	public Connection(String name) {
		this.name=name;
	}
	
	public void connect() {
		System.out.println("Connecting via "+name);
	}

	public String getName() {
		return name;
	}

}

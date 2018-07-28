package com.vijay.conpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnPoolTester {

	public static void main(String[] args) {
		testPool();

	}
	
	private static void testPool() {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		Runnable run = () ->{
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection conn =pool.getConnection();
			conn.connect();
			try{Thread.sleep(1500);}catch(Exception e) {};
			pool.returnConnection(conn);
		};
		for (int i=1;i<=100;i++) {
			executor.submit(run);
		}
		executor.shutdown();
	}

}

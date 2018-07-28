package com.vijay.conpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class ConnectionPool {
	
	private static ConnectionPool pool = new ConnectionPool();
	
	private BlockingQueue<Connection> connList= new ArrayBlockingQueue<Connection>(20);
	
	private ConnectionPool() {
		populateConnections();
	}
	
	public static ConnectionPool getInstance() {
		return pool;
	}
	
	public Connection getConnection() {
		try {
			Connection conn = connList.take();
			//System.out.println("Return connection "+conn.getName());
			//System.out.println("Size of pool is "+connList.size());
			return conn;
		}catch(Exception e) {
			System.out.println("Exception while fetching connection");
			return null;
		}
	}
	
	public void returnConnection(Connection conn) {
		if (conn != null) {
			try {
				connList.put(conn);
				System.out.println("Returned "+conn.getName());
			}catch(Exception e) {
				System.out.println("Exception returning connection for "+conn.getName());
			}
		}
	}
	
	private void populateConnections() {
		IntStream.range(1, 20).forEach(i ->  {
			try{
				connList.put(new Connection("Connection -"+i));
			}
			catch(Exception e) {}
		});
		System.out.println("Size of Connection list is "+ connList.size());
	}
	
	public static void main(String[] args) {
		ConnectionPool mypool = ConnectionPool.getInstance();
	}

}

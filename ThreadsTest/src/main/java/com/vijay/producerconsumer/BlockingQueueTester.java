package com.vijay.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueTester {

	private BlockingQueue<String> queue = new ArrayBlockingQueue<>(2000000);
	
	private ExecutorService writerService = Executors.newFixedThreadPool(5);
	private ExecutorService readerService = Executors.newFixedThreadPool(5);
	
	private AtomicInteger atomInt = new AtomicInteger(1);
	//private BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
	
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		BlockingQueueTester tester = new BlockingQueueTester();
		//tester.publishMessages();
		tester.startWriters();
		//tester.startReaders();
		tester.startCorrectReaders();
		//tester.startWriters();
		
		tester.stopAllProcessing();
	}
	
	private void stopAllProcessing() throws InterruptedException {
		Thread.sleep(5000);
		writerService.shutdown();
		while (!writerService.isTerminated()) {
			System.out.println("Waiting for Writter to die down");
		}
		while (!queue.isEmpty()) {
			Thread.sleep(2000);
			System.out.println("Wating for Readers to die down"+ queue.size());
		}
		readerService.shutdown();
		
	}
	
	public void startWriters() throws InterruptedException{
		Thread t = new Thread(() ->  {
			while(!writerService.isShutdown()) {
				try {
					queue.put("" +atomInt.incrementAndGet());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
				}
				
			}
		});
		t.start();
	}
	
	public void startCorrectReaders() {
		Thread t = new Thread(() ->  {
			while(!readerService.isShutdown()) {
				String newMessage = queue.poll();
				if (newMessage != null) {
					readerService.submit(new StringProcessingThread(newMessage));
				}
			}
		});
		t.start();
		
		
	}
	
	public void startReaders()  { //throws InterruptedException, ExecutionException
		readerService.submit(() ->{
			if (!queue.isEmpty()) {
				//Thread.sleep(1000);
				String name = Thread.currentThread().getName(); 
				String elementFetched =queue.remove();
				//String elementFetched =queue.poll();
				System.out.println("Fetch "+ name + "Element fetched was " + elementFetched +" and size of queue is "+ queue.size());
			}else {
				System.out.println("Queue is empty now");
			}
		});
		
		//System.out.println("Future returned on reader is "+returnedValue.get());
		
	}
	
	public void publishMessages() throws InterruptedException {
		for (int i = 1;i<=100000;i++) {
			queue.put(""+i);
		}
		System.out.println("Publish message completed");
	}
	
	/*public void startWriters()  { //throws InterruptedException, ExecutionException
		
		//writerService.
		writerService.submit(() ->{
			while(true) {
				Thread.sleep(300);
				String name = Thread.currentThread().getName(); 
				//boolean isSuccess =queue.add(name);
				boolean isSuccess =queue.offer(name);
				System.out.println("Add "+ name + "was successfule" + isSuccess +" and size of queue is "+ queue.size());
			}
		});
		
		//System.out.println("Future returned on writter is "+returnedValue.get());
		
		
		
	}*/
	
	
}

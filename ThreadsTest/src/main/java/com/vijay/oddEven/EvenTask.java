package com.vijay.oddEven;

public class EvenTask implements Runnable{

private OddEvenLock lock;
	
	public EvenTask(OddEvenLock obj) {
		lock= obj;
	}

	@Override
	public void run() {
		synchronized (lock) {
			if (lock.getCurrentValue() % 2 == 0) {
				return;
			}
			lock.setCurrentValue(lock.getCurrentEven());
			lock.setCurrentEven(lock.getCurrentEven() + 2);
			System.out.println("From even value "+ lock.getCurrentValue());
		}
		
		
	}
	

}

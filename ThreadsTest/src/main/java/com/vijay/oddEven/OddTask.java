package com.vijay.oddEven;

public class OddTask implements Runnable{
	
	private OddEvenLock lock;
	
	public OddTask(OddEvenLock obj) {
		lock= obj;
	}

	@Override
	public void run() {
		synchronized (lock) {
			//performCurrentLogic();
			performNewLogic();
			System.out.println("From odd value "+ lock.getCurrentValue());
		}
		
		
	}
	
	private void performNewLogic() {
		if (lock.getCurrentValue() % 2 != 0) {
			return;
		}
		lock.setCurrentValue(lock.getCurrentValue()+ 1);
	}
	
	private void performCurrentLogic() {
		if (lock.getCurrentValue() % 2 != 0) {
			return;
		}
		lock.setCurrentValue(lock.getCurrentOdd());
		lock.setCurrentOdd(lock.getCurrentOdd() + 2);
	}

}

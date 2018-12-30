package com.vijay.oddEven;

public class EvenTaskWaitNotify implements Runnable {

	private OddEvenLock lock;
	private boolean isEvenTask;

	public EvenTaskWaitNotify(OddEvenLock lock, boolean isEven) {
		this.lock = lock;
		this.isEvenTask = isEven;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				if (isEvenTask) {
					if (lock.getCurrentValue() % 2 == 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					if (lock.getCurrentValue() % 2 != 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				lock.setCurrentValue(lock.getCurrentValue() + 1);
				System.out.println("Printing from Even task " + lock.getCurrentValue());
				lock.notify();
			}
		}

	}

}

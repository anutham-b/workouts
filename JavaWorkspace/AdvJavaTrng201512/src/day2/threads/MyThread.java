package day2.threads;

import java.util.concurrent.TimeUnit;

/**
 * <b>Thread creation example</b></br>
 * Threading can be implemented by either extending Thread or implementing
 * Runnable.</br>
 * Use JConsole to view the live threads</br>
 * The main thread waits for Thread-TWO to finish.</br>
 * Upon completion of Thread-TWO, main thread too exits.</br>
 * The only thread left running is Thread-Three.</br>
 * </br>
 * 
 * Comment the workerThread2.join() to see all threads start and the main thread
 * die sooner.
 */
public class MyThread implements Runnable {

	private int count, sleepTime;

	public MyThread(int count, int sleepTime) {
		this.count = count;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Name: " + Thread.currentThread().getName() + " ID: " + Thread.currentThread().getId()
					+ " Priority: " + Thread.currentThread().getPriority() + " State: "
					+ Thread.currentThread().getState());
		}
		try {
			Thread.sleep(sleepTime * 1000);
			// Alternatively use
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyThread task1 = new MyThread(6, 15);
		MyThread task2 = new MyThread(3, 60);
		MyThread task3 = new MyThread(10, 15);

		Thread workerThread1 = new Thread(task1);
		workerThread1.setName("Thread-ONE");
		Thread workerThread2 = new Thread(task2);
		workerThread2.setName("Thread-TWO");
		Thread workerThread3 = new Thread(task3);
		workerThread3.setName("Thread-THREE");

		workerThread1.start();
		workerThread2.start();
		try {
			// Main thread to wait until workerThread2 to finish execution
			workerThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workerThread3.start();
	}

}

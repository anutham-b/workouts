package day3.executorframework;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {

	private Date date;
	private String name;

	public MyTask(Date date, String name) {
		this.date = date;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: %s created on %s\n", Thread.currentThread().getName(), name, date);

		System.out.printf("%s: %s started on %s\n", Thread.currentThread().getName(), name, new Date());

		try {
			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s: %s is executing for %d seconds\n", Thread.currentThread(), name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s: %s has finished on %s\n", Thread.currentThread().getName(), name, new Date());
	}

}

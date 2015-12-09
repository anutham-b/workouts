package day3.locks;

import java.util.concurrent.TimeUnit;

public class ReadUsingLocks implements Runnable {
	private Info info;
	
	public ReadUsingLocks(Info info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {
			System.out.printf("%s: Value1: %f\n",Thread.currentThread().getName(),info.getValue1());
			System.out.printf("%s: Value2: %f\n",Thread.currentThread().getName(),info.getValue2());
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

package day3.locks;

import java.util.concurrent.TimeUnit;

public class WriteUsingLocks implements Runnable {
	private Info info;
	
	public WriteUsingLocks(Info info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			info.writeValues((Math.random()*10), (Math.random()*10));
			System.out.printf("Values have been modified by: %s\n",Thread.currentThread().getName());
			try {
				TimeUnit.MILLISECONDS.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

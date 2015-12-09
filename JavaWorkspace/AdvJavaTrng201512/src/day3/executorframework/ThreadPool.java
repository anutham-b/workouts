package day3.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
	private ThreadPoolExecutor executor;

	public ThreadPool() {
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
	}

	public void executeTask(Runnable runnable) {
		System.out.println("Task has arrived");
		executor.execute(runnable);
		System.out.println("Pool size: " + executor.getPoolSize());
		System.out.println("Active count: " + executor.getActiveCount());
//		System.out.println("Completed task count: " + executor.getCompletedTaskCount());
	}

	public void shutdownPool() {
		System.out.println("About to terminate EXECUTOR");
		executor.shutdown();
	}
}

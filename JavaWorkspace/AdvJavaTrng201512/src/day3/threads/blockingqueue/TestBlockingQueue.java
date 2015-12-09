package day3.threads.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * This class creates a threads using executor framework to read and another
 * thread to write into the {@link EventManagerBlockingQueue} In case there are
 * two readers, there is no thread to notify the reader threads.
 */
public class TestBlockingQueue {
	public static void main(String[] args) {
		EventManagerBlockingQueue eventManager = new EventManagerBlockingQueue();
		ReadTaskBlockingQueue readTask1 = new ReadTaskBlockingQueue(eventManager);
		ReadTaskBlockingQueue readTask2 = new ReadTaskBlockingQueue(eventManager);
		WriterTaskBlockingQueue writerTask = new WriterTaskBlockingQueue(eventManager);

		List<Runnable> tasks = new ArrayList<>();
		tasks.add(readTask1);
		tasks.add(readTask2);
		tasks.add(writerTask);
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		for(Runnable runnable : tasks)
			executor.execute(runnable);
		
		executor.shutdown();

	}
}

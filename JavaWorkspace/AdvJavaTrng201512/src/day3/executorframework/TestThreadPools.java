package day3.executorframework;

/**
 * 100 tasks are executed on a thread pool of size 10. Each task executes for a
 * running time random (0-10 sec)
 *
 */
public class TestThreadPools {

	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool();
		for (int i = 0; i < 100; i++) {
			MyTask task = new MyTask(new java.util.Date(), "Task " + i);
			threadPool.executeTask(task);
		}
		threadPool.shutdownPool();

	}

}

package day3.threads;

/**
 * This class creates a thread to read and another thread to write into the
 * {@link EventManagerBlockingQueue} In case there are two readers, there is no
 * thread to notify the reader threads.</br>
 * This class uses {@link ReadTask}, {@link WriterTask} and {@link EventManager}
 */
public class WorkerThreads {
	public static void main(String[] args) {
		EventManager eventManager = new EventManager();
		ReadTask readTask = new ReadTask(eventManager);
		WriterTask writerTask = new WriterTask(eventManager);

		Thread writerThread = new Thread(writerTask, "WriterThread");
		Thread readerThread1 = new Thread(readTask, "ReaderThread1");
		Thread readerThread2 = new Thread(readTask, "ReaderThread2");

		writerThread.start();
		readerThread1.start();
		readerThread2.start();
	}
}

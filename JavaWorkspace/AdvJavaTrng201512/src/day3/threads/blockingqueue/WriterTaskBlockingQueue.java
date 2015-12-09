package day3.threads.blockingqueue;

/**
 * This class continuously writes into the Queue in {@link EventManagerBlockingQueue}
 *
 */
public class WriterTaskBlockingQueue implements Runnable {
	private EventManagerBlockingQueue eventManager;

	public WriterTaskBlockingQueue(EventManagerBlockingQueue eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			eventManager.write();
		}
	}

}

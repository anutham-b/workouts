package day3.threads.blockingqueue;

/**
 * This class continuously reads from the Queue in {@link EventManagerBlockingQueue}
 *
 */
public class ReadTaskBlockingQueue implements Runnable {
	private EventManagerBlockingQueue eventManager;

	public ReadTaskBlockingQueue(EventManagerBlockingQueue eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			eventManager.read();
		}
	}
}

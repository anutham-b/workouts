package day3.threads;

/**
 * This class continuously reads from the Queue in {@link EventManagerBlockingQueue}
 *
 */
public class ReadTask implements Runnable {
	private EventManager eventManager;

	public ReadTask(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			eventManager.read();
		}
	}
}

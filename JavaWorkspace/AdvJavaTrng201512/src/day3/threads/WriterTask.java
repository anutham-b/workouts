package day3.threads;

/**
 * This class continuously writes into the Queue in {@link EventManagerBlockingQueue}
 *
 */
public class WriterTask implements Runnable {
	private EventManager eventManager;

	public WriterTask(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			eventManager.write();
		}
	}

}

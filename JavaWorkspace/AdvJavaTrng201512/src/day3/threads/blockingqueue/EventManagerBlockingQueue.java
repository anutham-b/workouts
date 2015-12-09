package day3.threads.blockingqueue;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import day3.threads.EventManager;

/**
 * The {@link EventManager} is modified to change the queue into a {@link BlockingQueue}.</br> 
 * The wait-notify are removed as they are needed.
 *
 */
public class EventManagerBlockingQueue {

	private BlockingQueue<Date> events;

	public EventManagerBlockingQueue() {
		events = new LinkedBlockingQueue<>();
	}

	public void read() {
		System.out.println("Reader. Size: " + events.size() + " Thread: " + Thread.currentThread().getName()
				+ " Date: " + events.poll());
	}

	public void write() {
		try {
			events.put(new Date());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Writer. Size: " + events.size() + " Thread: " + Thread.currentThread().getName());
	}
}

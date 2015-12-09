package day2.threads;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class has a Queue and has public method to write and read into the Queue
 *
 */
public class EventManager {
	private int size;

	private Queue<Date> events;

	public EventManager() {
		size = 10;
		events = new LinkedList<>();
	}

	public synchronized void read() {
		while (events.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Reader. Size: " + events.size()+" Thread: "+Thread.currentThread().getName() + " Date: " + events.poll());
		notify();

	}

	public synchronized void write() {
		while (events.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		events.add(new Date());
		System.out.println("Writer. Size: " + events.size());
		notifyAll();
	}
}

package day2.collections;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import day2.generics.Customer;

public class QueueInterface {
	public static void main(String[] args) {
		Queue<Customer> queue = new LinkedList<>();
		queue.add(new Customer(2, "Name2", new Date()));
		queue.add(new Customer(1, "Name1", new Date()));
		queue.add(new Customer(3, "Name3", new Date()));
		queue.add(new Customer(5, "Name5", new Date()));

		// poll is the pop()
		System.out.println("Poll: " + queue.poll());
		System.out.println("Size: " + queue.size());

		// element() - retrieves, but does not remove
		System.out.println("Get: " + queue.element());
		System.out.println("Size: " + queue.size());

		// If queue empty, peek() returns null instead of an exception as with
		// element()
		System.out.println("Get: " + queue.peek());
		System.out.println("Size: " + queue.size());

	}
}

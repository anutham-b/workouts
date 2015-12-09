package day2.collections;

import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import day2.generics.Customer;

/**
 * A doubly-ended queue
 */
public class DequeueInterface {

	public static void main(String[] args) {
		Queue<Customer> queue = new LinkedList<>();
		queue.add(new Customer(2, "Name2", new Date()));
		queue.add(new Customer(1, "Name1", new Date()));
		queue.add(new Customer(3, "Name3", new Date()));
		queue.add(new Customer(4, "Name4", new Date()));

		// The doubly ended Queue collection
		Deque<Customer> deque = new LinkedList<>();
		deque.addAll(queue);
		deque.addLast(new Customer(5, "Name5", new Date()));
		deque.addFirst(new Customer(6, "Name6", new Date()));

		for (Customer c : deque) {
			System.out.println(c);
		}

		/*
		 * STACK
		 */

		Stack<Customer> stack = new Stack<>();
		stack.addAll(deque);

		System.out.println("Stack operations");
		System.out.println("Stack position from Top: "+stack.search(new Customer(2, "Name2", new Date())));
		System.out.println("Pop: "+stack.pop());
		System.out.println("Stack size: "+stack.size());
	}

}

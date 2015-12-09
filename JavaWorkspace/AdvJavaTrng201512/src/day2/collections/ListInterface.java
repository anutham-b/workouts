package day2.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import day2.generics.Customer;

/**
 * Demonstrating {@link List} operations
 *
 */
public class ListInterface {

	public static void main(String[] args) {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(1, "Name1", new Date()));
		list.add(new Customer(2, "Name2", new Date()));
		list.add(new Customer(4, "Name4", new Date()));
		list.add(new Customer(3, "Name3", new Date()));

		// Query operations
		System.out.println("List Size: " + list.size());
		System.out.println("List 2nd element get: " + list.get(2));

		// Remove operation
		System.out.println("Remove: " + list.remove(3));

		// Update operation
		System.out.println("Update: " + list.set(2, new Customer(22, "Name22", new Date())));

		// Iterate over the list
		Iterator<Customer> iter = list.iterator();
		System.out.println("----- Elements in list -----");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Using ListIterator
		ListIterator li = list.listIterator();
		while(li.hasNext()){
			if(li.nextIndex()==1){
				li.add(new Customer(100,"Name100",new Date()));
			}
			li.next();
		}
		
		// Display elements in reverse iteration order
		System.out.println("----- Elements in list (reverse order) -----");
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}
	}

}

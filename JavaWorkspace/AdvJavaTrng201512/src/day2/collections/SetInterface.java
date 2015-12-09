package day2.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import day2.generics.Customer;

public class SetInterface {
	public static void main(String[] args) {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(41, "Name41", new Date()));
		list.add(new Customer(1, "Name1", new Date()));
		list.add(new Customer(22, "Name22", new Date()));
		list.add(new Customer(3, "Name3", new Date()));
		list.add(new Customer(5, "Name4", new Date()));
		// Adding a duplicate element
		list.add(new Customer(3, "Name3", new Date()));

		System.out.println("List size: " + list.size());

		Set<Customer> set = new HashSet<>();
		set.addAll(list);

		System.out.println("Set size: " + set.size());

		// Remove an object from set
		System.out.println("Remove from set: " + set.remove(new Customer(3, "Name3", new Date())));
		System.out.println("Set size: " + set.size());

		// Display using for loop
		for (Customer cust : set) {
			System.out.println(cust);
		}

		// Using TreeSet makes the Set sorted during iteration.
		// Uses Comparator instead of the object implementing Comparable
		Set<Customer> treeset = new TreeSet<>(new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		treeset.addAll(list);
		System.out.println(" ----- TreeSet elements -----");
		for (Customer cust : treeset) {
			System.out.println(cust);
		}
	}
}

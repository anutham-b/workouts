package day2.collections;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import day2.generics.Customer;

public class MapInterface {
	public static void main(String[] args) {
		// Alternatively try with LinkedHashMap, TreeMap
		// LinkedHashMap retains the insertion order.
		Map<Integer, Customer> map = new LinkedHashMap<>();
		map.put(2, new Customer(2, "Name2", new Date()));
		map.put(5, new Customer(5, "Name5", new Date()));
		map.put(1, new Customer(1, "Name1", new Date()));
		map.put(3, new Customer(3, "Name3", new Date()));

		// Query operations
		System.out.println("Size: " + map.size());
		System.out.println("Get 3: " + map.get(3));
		System.out.println("Remove : " + map.remove(2).getId() + " Size: " + map.size());
		System.out.println("Contains Key: " + map.containsKey(5));

		// Iterating using the HashMap keys
		System.out.println("----- Iteration over keys -----");
		for (Integer key : map.keySet()) {
			System.out.println("Get: " + map.get(key));
		}
		
		// Iterating using the HashMap values
		System.out.println("----- Iteration over values -----");
		for(Customer cust : map.values()){
			System.out.println(cust);
		}
		
		// Iterate using key and value
		System.out.println("----- Iteration over EntrySet -----");
		for(Map.Entry<Integer, Customer> entry : map.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}

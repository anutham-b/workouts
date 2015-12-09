package day2.generics;

import java.util.Date;

/**
 * Bounded Generics -> {@code T extends Comparable<T>} </br>
 * Finding min and max for the types T, which are {@link Comparable}. i.e.,
 * extends Comparable</br>
 * 
 */
public class MinMaxArrayImpl<T extends Comparable<T>> implements IMinMaxArray<T> {

	private T values[];

	@SafeVarargs
	public MinMaxArrayImpl(T... values) {
		super();
		this.values = values;
	}

	@Override
	public T min() {
		T min = values[0];
		for (T val : values) {
			if (val.compareTo(min) < 0)
				min = val;
		}
		return min;
	}

	@Override
	public T max() {
		T max = values[0];
		for (T val : values) {
			if (val.compareTo(max) > 0)
				max = val;
		}
		return max;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// Integer array
		MinMaxArrayImpl<Integer> intArray = new MinMaxArrayImpl<>(100, 50, 111, 3);
		/*
		 * The <> in the above line is the Diamond operator. It helps in avoding
		 * declare as Integer on the new statement.
		 */
		System.out.println("Min value in intArray: " + intArray.min());
		System.out.println("Max value in intArray: " + intArray.max());

		// Double array
		MinMaxArrayImpl<Double> doubleArray = new MinMaxArrayImpl<>(10.245, 2.03550, 0.111, 3.215);
		System.out.println("Min value in doubleArray: " + doubleArray.min());
		System.out.println("Max value in doubleArray: " + doubleArray.max());

		
		// An array of Customer object which implements Comparable
		MinMaxArrayImpl<Customer> customerArray = new MinMaxArrayImpl<>(
				new Customer(1,"Name1",new Date()),
				new Customer(2,"Name2",new Date()),
				new Customer(3,"Name3",new Date()));
		System.out.println("Min value in customerArray: " + customerArray.min());
		System.out.println("Max value in customerArray: " + customerArray.max());

		// Tryout clone()
		Customer customer4 = new Customer(4,"Name4",new Date());
		Customer customer5 = customer4.clone();
		Customer customer6 = customer4.clone();
		System.out.println("---------- New customers ----------");
		customer4.setDob(new Date(System.currentTimeMillis()-1000000000));		
		System.out.println(customer4);
		// The DOB are expected to be unchanged for c5 and c6.
		System.out.println(customer5);
		System.out.println(customer6);
		MinMaxArrayImpl<Customer> customer1Array = new MinMaxArrayImpl<>(customer4,customer5,customer6);

	}

}

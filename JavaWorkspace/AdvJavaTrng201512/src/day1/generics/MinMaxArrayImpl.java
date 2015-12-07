package day1.generics;

/**
 * Bounded Generics -> {@code T extends Comparable<T>} </br>
 * Finding min and max for the types T, which are {@link Comparable}. i.e., extends Comparable</br>
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
		for(T val : values){
			if(val.compareTo(min)<0)
				min = val;
		}
		return min;
	}

	@Override
	public T max() {
		T max = values[0];
		for(T val : values){
			if(val.compareTo(max)>0)
				max = val;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

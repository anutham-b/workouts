package day1.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 
 */
public class MethodReflection {

	public static void display(Shape shape) {
		System.out.println("Area of " + shape.getClass().getSimpleName() + " " + shape.calculateArea());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the shape class");
		String className = scanner.nextLine();
		Class clazz = null;
		try {
			clazz = Class.forName("day1.reflection." + className);
			Object shape = clazz.newInstance();
			// Get the method setWidth which accepts double as an argument
			Method setWidth = clazz.getMethod("setWidth", double.class);
			Method setHeight = clazz.getMethod("setHeight", double.class);
			setWidth.invoke(shape, 23.11);
			setHeight.invoke(shape, 11.1);
			MethodReflection.display((Shape) shape);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	}
}

package day1.traversehierarchy;

/**
 * Traverse the super classes till to Object and list the hierarchy
 */
public class SuperClassReflection {

	public static void findSuperClasses(Class<?> clazz) {
		Class superclass = clazz.getSuperclass();
		while (superclass != null) {
			System.out.println(superclass.getName());
			superclass = superclass.getSuperclass();
		}
	}

	public static void main(String[] args) {
		findSuperClasses(MyException.class);
	}
}

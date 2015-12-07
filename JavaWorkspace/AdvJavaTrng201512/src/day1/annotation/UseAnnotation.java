package day1.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Class which uses the {@link CustomAnnotation}ation
 * TRY: Change the RETENTION of {@link CustomAnnotation} to source and the values cannot be retrieved 
 */
public class UseAnnotation {

	@CustomAnnotation("Some value")
	public static void hello() {
		System.out.println("Inside hello");
	}

	public static void main(String[] args) {
		Class<?> clazz = UseAnnotation.class;
		try {
			Method method = clazz.getMethod("hello");
			Annotation[] annotations = method.getAnnotations();
			for (Annotation ant : annotations) {
				if (ant.annotationType().getName().equals("day1.annotation.CustomAnnotation")) {
					CustomAnnotation ca = (CustomAnnotation) ant;
					System.out.println(ca.value());
				}
			}
			// OR ALTERNATIVELY LOAD DIRECTLY
			CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
			System.out.println(customAnnotation.value());
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

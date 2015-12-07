package day1.reflection;

public class Triangle extends Shape {

	public Triangle() {
	}

	public Triangle(double width, double height) {
		super(width, height);
	}

	@Override
	public double calculateArea() {
		return 0.5 * getWidth() * getHeight();
	}

}

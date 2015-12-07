package day1.reflection;

public class Rectangle extends Shape {

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public double calculateArea() {
		return getWidth() * getHeight();
	}

}

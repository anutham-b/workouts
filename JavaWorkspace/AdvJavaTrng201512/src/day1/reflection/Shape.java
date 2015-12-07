package day1.reflection;

public abstract class Shape {
	private double width, height;
	
	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract double calculateArea();
}

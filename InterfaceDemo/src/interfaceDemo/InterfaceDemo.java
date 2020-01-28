package interfaceDemo;

interface Shape {
	// abstract method
	void draw();

	double area();
}

class Rectangle implements Shape {
	private int length, width;

	// constructor
	Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("Rectangle has been drawn ");
	}

	@Override
	public double area() {
		return (double) (length * width);
	}
}

class Circle implements Shape {
	private double pi = 3.14;
	private int radius;

	// constructor
	Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle has been drawn ");
	} 

	@Override
	public double area() {
		return pi * radius * radius;
	}

}

public class InterfaceDemo {
	public static void main(String[] args) {
		// creating the Object of Rectangle class
		// and using shape interface reference.
		Shape rect = new Rectangle(2, 3);
		System.out.println("Area of rectangle: " + rect.area());

		// creating the Objects of circle class
		Shape circle = new Circle(2);
		System.out.println("Area of circle: " + circle.area());
	}
}

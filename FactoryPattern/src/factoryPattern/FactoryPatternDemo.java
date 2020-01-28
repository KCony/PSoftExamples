package factoryPattern;

interface Shape {
	void draw();
}	

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw() method.");
	}
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw() method.");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw() method.");
	}
}

class ShapeFactory {

	//use getShape method to get object of type shape 
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null; // maybe better to throw an exception?
		}		
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();

		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();

		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}

		return null;  // maybe better to throw an exception
	}
}

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		//get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		//call draw method of Circle
		shape1.draw();

		//get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		//call draw method of Rectangle
		shape2.draw();

		//get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		//call draw method of circle
		shape3.draw();
	}
}

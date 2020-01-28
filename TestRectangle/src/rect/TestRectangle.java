package rect;

class Rectangle {
	protected int width;
	protected int height;
	
	void setSize(int w, int h) {
		width = w;
		height = h;
	}
	
	int area() {
		return width * height;
	}
}

// choice 2
class Square extends Rectangle {
	@Override
	public void setSize(int w, int h) {
		width = w;
		height = w;
	}
	
	@Override
	int area() {
		return width * width;
	}
}

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r = new Square();
		r.setSize(5,4); 
		System.out.println(r.area()==20);  // r.area() returns 25
	}
}

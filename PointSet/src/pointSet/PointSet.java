package pointSet;

import java.util.List;
import java.util.ArrayList;

class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() { return x; }  // rep exposure?
	int getY() { return y; }
	
	void setX(int x) { this.x = x; }
	void setY(int y) { this.y = y; }
	
	void print() { System.out.println("x = " + x + " y = " + y); }
}

public class PointSet {
	// Rep Invariant: data contains no duplicates and no nulls
	private List<Point> data = new ArrayList<Point>();
	
	public void add(Point p) { 
		if(! contains(p))
			data.add(p); 
	}
	public void remove(Point p) {
		data.remove(p);  // reference equality
	}
	public boolean contains(Point p) {
		return data.contains(p);  // checks by reference equality
	}
	public int size() { return data.size(); };

	public List<Point> getElements() { return new ArrayList<Point>(data); }

	public void print() {
		for(Point p : data) {
			p.print();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		Point p2 = new Point(3,3);
		Point p3 = new Point(1,2);
		
		PointSet ps = new PointSet();
		ps.add(p1);
		ps.add(p2);
//		ps.add(p3);
		ps.print();
		
		List<Point> lp = ps.getElements();
//		lp.remove(p1);
//		ps.remove(p3);
		ps.print();  // safe?
		
//		p1.setY(57);
//		ps.print();  // Huh?!
		
//		p1.setX(3);
//		p1.setY(3);
//		ps.print(); // Uh-oh
	}
}

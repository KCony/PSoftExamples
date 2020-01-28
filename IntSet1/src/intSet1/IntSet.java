package intSet1;

// version 1

import java.util.List;
import java.util.ArrayList;

public class IntSet {
	// Rep Invariant: data contains no duplicates and no nulls
	private List<Integer> data = new ArrayList<Integer>();
	
	public void add(Integer x) { 
		if(! contains(x))
			data.add(x); 
	}
	public void remove(Integer x) {
		data.remove(x);
	}
	public boolean contains(Integer x) {
		return data.contains(x);
	}
	public int size() { return data.size(); };

	// public List<Integer> getElements() { return data;}

	public List<Integer> getElements() { return new ArrayList(data);}

	public void print() {
		for(Integer i : data) {
			System.out.println(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		IntSet s = new IntSet();
		s.add(27);
		s.add(28);
		s.print();

		List<Integer> li = s.getElements();
		li.remove(0); // alters s?
		s.print();
	}

}

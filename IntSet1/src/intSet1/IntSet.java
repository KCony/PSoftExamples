package intSet1;

// version 1

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class IntSet {
	// Rep Invariant: data contains no duplicates and no nulls
	private List<Integer> data = new ArrayList<Integer>();
	
	public void add(Integer x) { 
		checkRep();
		if(! contains(x))
			data.add(x);
		checkRep();
	}
	public void remove(Integer x) {
		checkRep();
		data.remove(x);
		checkRep();
	}
	public boolean contains(Integer x) {
		return data.contains(x);
	}
	public int size() { return data.size(); };

	public List<Integer> getElements() { return data;}

//	public List<Integer> getElements() { return new ArrayList<Integer>(data);}

	public void print() {
		checkRep();
		for(Integer i : data) {
			System.out.println(i);
		}
		System.out.println();
		checkRep();
	}
	
	private void checkRep() {
		for(Integer d : data)
			if(d == null)
				throw new NullPointerException("null data");		
//		Set<Integer> set = new HashSet<Integer>(data);
//		if(set.size() != data.size())
//		     throw new RuntimeException("duplicates!");
	}

	public static void main(String[] args) {
		IntSet s = new IntSet();
		s.add(27);
		s.add(28);
		s.add(28);
		s.print();

		List<Integer> li = s.getElements();
//		li.remove(0); // alters s?
//		li.add(28);
//		s.print();
	}

}

package intset2;

// version 3

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class IntIterator {
	private List<Integer> theData;
	private int next;
	
	public IntIterator(List<Integer> data) {
		theData = new ArrayList<Integer>(data); 
		next = 0; 
	}
	
	public boolean hasNext() {
		return (next < theData.size());
	}
	
	public int next() {
		return theData.get(next++);
	}
}

public class IntSet {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer x) { 
		if(! data.contains(x))
			data.add(x); 
	}

	public void remove(Integer x) {
		data.remove(x);
	}
	public boolean contains(Integer x) {
		return data.contains(x);
	}
	
	// is this a rep exposure?
	public int size() { return data.size(); };

	// rep exposure
	public List<Integer> getElements() { return data;}

	public void print() {
		for(Integer i : data) {
			System.out.println(i);
		}
	}
	
	private void checkRep() {
		Set<Integer> set = new HashSet<Integer>(data);
		if(set.size() != data.size())
		     throw new RuntimeException("duplicates!");
	}


	public IntIterator iterator() {
		return new IntIterator(data);
	}

	public static void main(String[] args) {
		IntSet set1 = new IntSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(2);
		set1.print();
		System.out.println();

		IntIterator it = set1.iterator();
		it.next();
//		 this will cause an error
//		 it.remove();
		set1.print();
	}

}

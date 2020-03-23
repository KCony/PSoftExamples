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

public class IntSet2 {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer x) {
		checkRep();
		if(! data.contains(x))
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
	
	// is this a rep exposure?
	public int size() { return data.size(); };

	// rep exposure
	public List<Integer> getElements() { return data;}

	public void print() {
		checkRep();
		for(Integer i : data) {
			System.out.println(i);
		}
		checkRep();
	}
	
	private void checkRep() {
		for(Integer d : data)
			if(d == null)
				throw new NullPointerException("null data");
		Set<Integer> set = new HashSet<Integer>(data);
		if(set.size() != data.size())
		     throw new RuntimeException("duplicates!");
	}


	public IntIterator iterator() {
		return new IntIterator(data);
	}

	public static void main(String[] args) {
		IntSet2 set1 = new IntSet2();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(2);
		set1.print();
		System.out.println();

		IntIterator it = set1.iterator();
		it.next();
//		it.add(2);
//		it.remove();
		set1.print();
	}

}

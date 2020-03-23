import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class IntSet {
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
	
	public Iterator<Integer> iterator() {
		return data.iterator(); 
	}
	
	private void checkRep() {
		for(Integer d : data)
			if(d == null)
				throw new NullPointerException("null data");
		Set<Integer> set = new HashSet<Integer>(data);
		if(set.size() != data.size())
		     throw new RuntimeException("duplicates!");
	}
		  
	public static void main(String[] args) {
		IntSet set1 = new IntSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(2);
		set1.print();
		System.out.println();
		
		Iterator<Integer> it = set1.iterator();
		it.next();
//		it.remove();
//		it.add(2);
		set1.print();
	}

}

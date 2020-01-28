import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
	public int size() { return data.size(); };
	
	// rep exposure
	public List<Integer> getElements() { return data;}
	
	public void print() {
		for(Integer i : data) {
			System.out.println(i);
		}
	}
	
	public Iterator<Integer> iterator() {
		return data.iterator(); 
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
		it.remove();
		set1.print();
	}

}

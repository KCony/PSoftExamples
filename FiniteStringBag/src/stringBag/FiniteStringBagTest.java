package stringBag;

import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.lang.NullPointerException;

class FiniteStringBag {
	// Rep: items[0..size-1] contains Strings
	// Entries are not null. There may be multiple copies
	// of the same string in the FiniteStringBag (FSB).

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + size;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FiniteStringBag))
			return false;
		FiniteStringBag other = (FiniteStringBag) obj;
		if (size != other.size)
			return false;
		for(int i = 0; i < size; i++) {
			if(! items[i].equals(other.get(i)))
				return false;					
		}
			
		return true;
	}

	private String[] items;
	private int size;
	
	//Construct new FSB with given capacity. 
	// Requires: capacity > 0
	public FiniteStringBag(int capacity) {
		this.items = new String[capacity];
		this.size = 0;
	}
	
	/** Return capacity of this FSB */
	public int capacity() { return items.length; }
	
	/** Return current size of this FSB*/
	public int size() { return size; }
	
	/** Return item at position i of this FSB */
	public String get(int i) {
		if(i > size)
			throw new IndexOutOfBoundsException();
		return items[i];
	}
	
	public void add(String s) {
		if(size == items.length)
			throw new BufferOverflowException();
		items[size] = s;
		size = size + 1;
	}
	
	/** Return whether s is located in this FSB */
	public boolean contains(String s) {
		if (size == 0) return false;
		
		for(int i = 0; i < size; i++) {
			if(items[i].equals(s))
				return true;
		}
		
		return false;
	}
	
	// delete strings with length > n
	public void deleteLongStrings(int n) {
		int k = 0;
		while (k < size) {
			if (items[k].length() > n) {
				items[k] = items[size-1];
				size = size-1;
			} else {
				k = k + 1;
			}
		}
	}
	
	// additional methods to be added later...…
	
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.println(items[i]);
		}
	}
}


public class FiniteStringBagTest {

	public static void main(String[] args) {
		FiniteStringBag fsb = new FiniteStringBag(10);		
		String s = "a";
		for(int i = 0; i < 10; i++) {
			fsb.add(s);
			s = s + "a";
		}		
		fsb.print();
		
//		fsb.deleteLongStrings(5);
//		System.out.println();
//		fsb.print();
		
		// fsb.add("b");
		
		String s2 = "a";
		FiniteStringBag fsb2 = new FiniteStringBag(10);
		for(int i = 0; i < 10; i++) {
			fsb2.add(s2);
			s2 = s2 + "a";
		}
		System.out.println();
		System.out.println(fsb.equals(fsb2));
		
		FiniteStringBag fsb4 = new FiniteStringBag(10);
		fsb4.add("a");
		System.out.println(fsb4.contains(new String("a")));
		System.out.println(fsb4.contains(new String("b")));
		
		FiniteStringBag fsb3 = new FiniteStringBag(10);
		String s3 = "a";
		for(int i = 0; i < 20; i++) {
			fsb3.add(s3);
			s3 = s3 + "a";
		}
				
	}

}

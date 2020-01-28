package setInterfaceTest;

import java.util.Collection;
import java.util.List;

public class SetInterFaceTest {

	interface Set<E> {
		  // Adds all elements in c to this set
		  // if they are not already present.
		  void addAll(Set<E> c); 
//		  void addAll(Collection<E> c);
//		  void addAll(Collection<? extends E> c);
		  <T extends E> void addAll(Collection<T> c);
		}
	
	class Myset<E> implements Set<E> {
		public void addAll(Set<E> c) { }
		public <T extends E> void addAll(Collection<T> c) { }
	}

	public static void main(String[] args) {
		Myset<Number> s; 
		List<Number> l;
		s.addAll(l);
	}

}

package comparableTest;

import java.util.ArrayList;
import java.util.HashMap;

class Edge<E extends Comparable<E>, N extends Comparable<N>> implements Comparable<Edge<E, N>> {
	
	private HashMap<E, ArrayList<Edge<E,N>>> arrl;
	
	public int compareTo(Edge<E,N> o) {
		Edge<E,N> o1 = this;
		Edge<E,N> o2 = o;
		
		return o1.compareTo(o2);
	}
}

class Graph<E extends Comparable<E>, N extends Comparable<N>> {
	private HashMap<E, ArrayList<Edge<E,N>>> arrl;
	
}

public class ComparableTest {

	public static void main(String[] args) {

	}

}

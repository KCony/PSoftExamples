package mySetDemo;

import java.util.List;

class MySet<T> {
	  // rep invariant: non-null, 
	  // contains no duplicates
	  List<T> theRep;
	  T lastLookedUp;
	}

public class MySetDemo {
	MySet<String> s;
	MySet<Integer> intSet;
	MySet<int> i; // compiler error
}

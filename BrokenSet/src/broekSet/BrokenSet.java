package broekSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BrokenSet {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("cat");
		
		Set<List<String>> set = new HashSet<List<String>>();
		set.add(list);
		
		System.out.println("Added List: " + set.contains(list));
		
		list.add("dog");
		System.out.println("After dog: " + set.contains(list));
		
		System.out.println();
		System.out.println("Loop");
		for (List<String> l : set) { 
		    System.out.println(set.contains(l)); 
		}
	}

}

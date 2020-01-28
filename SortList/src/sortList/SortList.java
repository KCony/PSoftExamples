package sortList;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class SortList {

	public <T extends Comparable<T>>  int compareTo(T arg1, T arg2) {
		return arg1.compareTo(arg2);
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("fish");
		
		Collections.sort(list);
		
	}

}

package javaVariables;

import java.util.List;
import java.util.Arrays;

public class JavaVariables {

	public static void main(String[] args) {
		int x = 3;
		int y = x;
		System.out.println(x + " " + y);
		
		x = 2;
		System.out.println(x + " " + y);
		
		List<String> aList = Arrays.asList("one", "two", "three");
		List<String> anotherList = aList;
		System.out.println(aList + " " + anotherList);
		
		aList.set(1, new String("cat"));
		System.out.println(aList + " " + anotherList);
	}

}

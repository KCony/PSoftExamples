package funCharConverter;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class FunCharConverterDemo{

	/**
	 * Convert elements in a Collection to upper case using Java 7
	 * @param inList
	 * @return
	 */
	public static List<String> convertToUpperCase7(List<String> inList) {
		List<String> list = new ArrayList<String>();
		for (String str : inList) {
			list.add(str.toUpperCase());
		}
		return list;
	}

	/**
	 * Convert elements in a Collection to upper case using Java 8
	 * @param inList
	 * @return
	 */
	public static List<String> convertToUpperCase8(List<String> inList) {
		return inList.stream() // Convert collection to Stream
				.map(String::toUpperCase) // Convert each element to upper case
				.collect(toList()); // Collect results to a new list
	}

	public static void main(String[] args) {
		List<String> inList = new ArrayList<>();
		inList.add("a");
		inList.add("b");
		inList.add("c");
		inList.add("d");
		System.out.println("Input List >> " + inList);
		System.out.println("toUpper by Java 7 >> " + convertToUpperCase7(inList));
		System.out.println("toUpper by Java 8 >> " + convertToUpperCase8(inList));
	}
}
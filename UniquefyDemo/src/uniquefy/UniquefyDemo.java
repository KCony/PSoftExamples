package uniquefy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquefyDemo {
	static void uniquefy(List<Integer> lst) { 
		for (int i = 0; i < lst.size()-1; i++) 
			if (lst.get(i).intValue() == lst.get(i+1).intValue())
				lst.remove(i);
	}
	
//	static void uniquefy(List<Integer> lst) {
//		// make a copy without duplicates 
//		Set<Integer> dup = new LinkedHashSet<Integer>(lst); 
//		lst.clear();
//		lst.addAll(dup); // add the items back 
//	}

//	static List<Integer> uniquefy(List<Integer> lst) { 
//		List<Integer> lst2 = lst.stream().distinct().collect(Collectors.toList());
//		return lst2;
//	}

//	static void uniquefy(List<Integer> lst) {
//		List<Integer> lst2 = lst.stream().distinct().collect(Collectors.toList());
//		lst.clear();
//		lst.addAll(lst2);
//	}

	public static void main(String args[]) {
		List<Integer> lst = new ArrayList<Integer>(Arrays.asList(1,1,2,2,3));
		//List<Integer> lst = new ArrayList<Integer>(Arrays.asList(1,1,2,3,4,4,4,5,6,1));
		uniquefy(lst);
//		lst = uniquefy(lst);
		System.out.print(lst);
	}
}

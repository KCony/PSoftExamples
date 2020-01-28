import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		List<String> friends = 
				new LinkedList<String>(Arrays.asList("yoda", "zaphod"));
		List<String> enemies = 
				new LinkedList<String>(Arrays.asList("Darth Vader", "Joker"));

		Set<List<String>> h = new HashSet<List<String>>();
		h.add(friends);
		System.out.print("friends hashcode: ");
		System.out.println(friends.hashCode());
		
		h.add(enemies);
		
		friends.add("BatMan");
		System.out.print("friends hashcode after adding BatMan: ");
		System.out.println(friends.hashCode());

		System.out.println(h.contains(friends)); // expects hashCode to be same as when friends was added
		System.out.println();
		
		for (List<String> lst : h) {
			System.out.println(lst);
			System.out.println(lst.equals(friends));
			System.out.println(lst.hashCode());
		}
	}

}

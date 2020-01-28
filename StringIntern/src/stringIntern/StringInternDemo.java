package stringIntern;

public class StringInternDemo {

	public static void main(String[] args) {
		String a = "cat";
		String b = "cat";
		String c = new String("cat");

		System.out.println(a == b);   // prints true
		System.out.println(a.equals(b));  // prints true

		System.out.println(a == c);   // prints false
		System.out.println(a.equals(c));  // prints true
	}

}

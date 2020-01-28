package stringTest;


public class StringTest {

	public static void main(String[] args) {
		String a = new String("cat");
		String b = new String("cat");
		
		String c = b;
		
		// what does this output?
		System.out.println(a == b);
		System.out.println(c == b);
		
		System.out.print(a.equals(b));
	}
}


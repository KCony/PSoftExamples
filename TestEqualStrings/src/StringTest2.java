
public class StringTest2 {
	public static void main(String[] args) {
		String a = "cat";
		String b = "cat";
		
		String c = b;
		
		// what does this output?
		System.out.println(a == b);
		System.out.println(c == b);
		
		System.out.println(a.equals(b));
	}
}

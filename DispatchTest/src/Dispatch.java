
public class Dispatch {

	public static void main(String[] args) {
		String t = new String("ab");
		Object o = t + "c"; // concatenation
		String r = new String("abc");
		boolean b = o.equals(r);
		System.out.println(b);
	}

}

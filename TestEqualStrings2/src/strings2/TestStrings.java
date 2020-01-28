package strings2;

public class TestStrings {

	public static void main(String[] args) {
		String s1 = new String("ab");
		String s2 = s1 + "c";
		String s3 = new String("abc");
//		System.out.println(s2.equals(s3));
		System.out.println(s1 == s2);
	}

}

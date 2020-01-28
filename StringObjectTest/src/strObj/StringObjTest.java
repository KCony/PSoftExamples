package strObj;

public class StringObjTest {

	public static void main(String[] args) {
		Object o = new Object();
		String s = new String("hi ") + o;
		
		System.out.println(s);
		System.out.println(o);
	}

}

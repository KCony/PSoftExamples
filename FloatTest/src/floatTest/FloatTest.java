package floatTest;

public class FloatTest {

	public static void main(String[] args) {
		Float f1 = new Float(3.1);
		Float f2 = new Float(3.1);
		Float f3 = (float) 3.1;
		Float f4 = (float) 3.1;
		
		System.out.println(f1.equals(f2));
		System.out.println(f1 == f2);
		System.out.println(f3.equals(f4));
		System.out.println(f3 == f4);
	}

}

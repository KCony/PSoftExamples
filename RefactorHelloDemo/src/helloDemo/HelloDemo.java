package helloDemo;

public class HelloDemo {

	class HelloThere {
		public void sayIt() {
			System.out.println("Bonjour");
		}
	}

	public static void main(String[] args) {
		String[] myList = {"Hello", "Hi", "Howdy"};

		int num = 1;
		System.out.println(num + 1);

		HelloDemo h = new HelloDemo();
		HelloThere test = h.new HelloThere();

		for(String t : myList) {
			System.out.println(t);
		}
	}
}


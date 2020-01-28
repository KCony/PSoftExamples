package person;

public class Person {
	private String name;

	public Person(String theName) {
		this.name = theName;
	}

	public static void main(String[] args) {
		Person p1 = new Person("Kairen");
		Person p2 = new Person("Kairen");
		Person p3 = p2;

		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		System.out.println(p1.equals(p3));
	}
}

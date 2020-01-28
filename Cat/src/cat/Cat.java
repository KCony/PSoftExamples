package cat;

public class Cat{
	String name;
	public Cat(String name){
		this.name=name;
	}
	public static void main(String[] args){
		Cat cat1 = new Cat("Scamper"); 
		Cat cat2 = new Cat("Scamper");
		System.out.println(cat1.equals(cat2));
	}
}
package animals;

class GenericAnimal {
	public String talk() { 
		return "Noise"; }
}

class Bird extends GenericAnimal {
	public String talk(){ 
		return "Chirp"; }
}

class Cat extends GenericAnimal {
	public String talk(){ 
		return "Meow"; }
}

class Dog extends GenericAnimal {
	public String talk(){ 
		return "Woof"; }
}

class GizmoTheCat extends Cat {
	public String talk(){ 
		return "Hello, I would like some oatmeal."; }
}

public class AnimalTalk {
	public static void main(String[] args) {
		GenericAnimal A = new GenericAnimal();
		System.out.println(A.talk());

		GenericAnimal B = new Bird();
		System.out.println(B.talk());

		GenericAnimal C = new Cat();
		System.out.println(C.talk());

		GenericAnimal G = new GizmoTheCat();
		System.out.println(G.talk());

		// what does this print?
		GizmoTheCat G2 = new GizmoTheCat();
		GenericAnimal F = G2;  // Compile time type? Runtime type?
		System.out.println(F.talk());

	}

}

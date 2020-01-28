package funState;

public class FunStateDemo {

	public static void call(Runnable runnable) {
		runnable.run();
	} 

	public static void main(String[] args) {
		System.out.println("Player is in start state");
		call(
				() -> System.out.println("Start State")
				);

		System.out.println("Player is in stop state");
		call(
				() -> System.out.println("Stop State")
				);
	}

}

//package funStategyDemo;

@FunctionalInterface
interface Strategy {
	double apply(double a, double b);
};

public class FunStrategyDemo {
	public static double execute(double a, double b, Strategy strategy) {
		return strategy.apply(a, b);
	}

	public static void main(String[] args) {
		System.out.println(execute(10, 5, (a, b) -> a + b));
		System.out.println(execute(10, 5, (a, b) -> a - b));
		System.out.println(execute(10, 5, (a, b) -> a * b));
	}
}

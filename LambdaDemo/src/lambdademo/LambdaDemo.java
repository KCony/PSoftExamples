package lambdademo;

public class LambdaDemo {
	
	@FunctionalInterface
	public interface BinaryOperator<T> {
	    public T apply(T left, T right);
	}

	public static void main(String[] args) {
		BinaryOperator<Integer> addition = (a, b) ->  a + b;
		BinaryOperator<Integer> subtraction = (a, b) ->  a - b;
		BinaryOperator<Integer> multiplication = (a, b) ->  a * b;
		BinaryOperator<Integer> division = (a, b) ->  a / b;
		
		System.out.print("10 + 5 = ");
		System.out.println(addition.apply(5,  10));
		System.out.print("10 - 5 = ");
		System.out.println(subtraction.apply(5,  10));
		System.out.print("10 * 5 = ");
		System.out.println(multiplication.apply(5,  10));
		System.out.print("10 / 5 = ");
		System.out.println(division.apply(5,  10));
	}
}

package typeConstraint;

public class TypeConstraintDemo {
	static int sum(int[] arr, int len) {
		int result = 0;
		int i = 0;
		while (i < len) {
			result = result + arr[i];
			i = i+1;
		}
		return result;
	}  

	static Number sum2(Number[] arr, int len) {
		int result = 0;
		int i = 0;
		while (i < len) {
			result = result + arr[i].intValue();
			i = i+1;
		}
		return result;
	}  

	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5};
		Integer [] arr2 = {1, 2, 3, 4, 5};
		// Double [] arr2 = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] s = {"a", "b", "c", "d"};
		
		System.out.println(sum(arr, arr.length));
		System.out.println(sum2(arr2, arr2.length));
		// System.out.println(sum(s, s.length));
	}

}

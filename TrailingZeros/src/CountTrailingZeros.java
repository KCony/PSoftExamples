public class CountTrailingZeros {

	public static void main(String[] args) {
		int y = 1134;
		
		int trailingZeros = String.valueOf(y).length() - String.valueOf(y).replaceAll("0*$","").length();
		System.out.println(trailingZeros);
	}

}

package illegalArgDemo;

public class IlleaglArgDemo {
	
	// throws: IllegalArgumentException if arg is not a valid UTF-16
	//returns: a char array having codePoint's UTF-16 representation
	static char []  convertCode(int c) throws IllegalArgumentException {
		return Character.toChars(c);
	}

	public static void main(String[] args) {
		int cp = -1;	
		try {
			char [] res = convertCode(cp);
			System.out.println(res);
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid Unicode");
			e.printStackTrace();
		}
	}

}

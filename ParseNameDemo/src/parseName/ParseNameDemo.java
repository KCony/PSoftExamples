package parseName;

public class ParseNameDemo {
	
	static String[] parseName(String name) {
		  int comma = name.indexOf(",");
		  String firstName = name.substring(0,comma);
		  String lastName = name.substring(comma+2);
		  return new String[] { lastName, firstName };
		}

	public static void main(String[] args) {
		String [] str = parseName("Jane, Doe");
		System.out.println(str[0] + "-" + str[1]);

		str = parseName("Jane,Doe");
		System.out.println(str[0] + "-" + str[1]);

		str = parseName("Jane Doe");
		System.out.println(str[0] + "-" + str[1]);
	}

}

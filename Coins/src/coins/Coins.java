package coins;

public class Coins {
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;

	public int total() {return pennies + 5 * nickels + 10 * dimes + 25 * quarters;}

	public boolean equals(Object other) {
		if (!(other instanceof Coins)) return false; 
		Coins c = (Coins) other; 
		return this.total() == c.total();
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

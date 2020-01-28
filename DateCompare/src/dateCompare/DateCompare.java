package dateCompare;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class DateCompare {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Set<Date> s = new HashSet<Date>();
		Date d1 = new Date();
		Date d2 = new Date(); //  later
		d1.setTime(0);
		d2.setTime(1000);
		System.out.println("d1 " + d1 + " " + d1.hashCode());
		System.out.println("d2 " + d2 + " " + d2.hashCode());
		
		System.out.println("\nAdd to set");
		s.add(d1); 
		s.add(d2);
		// d2 is in bucket 1000
		System.out.println("d2 " + d2 + " " + s.contains(d2)+ " " + d2.hashCode() );
		
		// change d2 - look in bucket 10000, d2 is not there
		d2.setTime(10000);
		System.out.println("\nd2 " + d2 + " " + s.contains(d2)+ " " + d2.hashCode() );
		
		// look in bucket 10000, nothing there
		Date d3 = new Date(10000);
		System.out.println("d3 " + d3 + " " + s.contains(d3)+ " " + d3.hashCode() );
		
		// look in bucket 1000, d2 used to be there, but it doesn't match any more, d2 has time 10000
		Date d4 = new Date(1000);
		System.out.println("d4 " + d4 + " " + s.contains(d4)+ " " + d4.hashCode()); 
		
		System.out.println("set s");
		Iterator<Date> it = s.iterator();
		while(it.hasNext()) {
			Date d = it.next();
			System.out.println(d + " " + d.hashCode());
		}
		
		// back to where we started - look in 1000, find a match
		d2.setTime(1000);
		System.out.println("\nd2 " + d2 + " " + s.contains(d2)+ " " + d2.hashCode() );

		// how about d4 - it hash same value and hash as d2
		System.out.println("\nd4 " + d4 + " " + s.contains(d4)+ " " + d4.hashCode() );

	}

}

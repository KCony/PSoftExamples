
public class WhichYear {
	private static boolean isLeapYear(int y) { 
		  return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
	}

	public static int whichYear_Loop(int d) {
		int days = d;
		int year = 1970; // 1980;
		while (days > 365) {
			if (isLeapYear(year)) {
				if (days > 366) {
					days = days - 366;
					year = year + 1;
				}
			} else {
				days = days - 365;
				year = year + 1;
			}
		}
		return year;
	}
	
	public static void main(String[] args) {
		System.out.println(whichYear_Loop(20));
		System.out.println(whichYear_Loop(365));
		System.out.println(whichYear_Loop(366));
		System.out.println(whichYear_Loop(367));
		System.out.println(whichYear_Loop(1480));
		System.out.println(whichYear_Loop(14401));
		System.out.println(whichYear_Loop(14646));
	}

}

// Bug fixed:
//public class WhichYear {
//	private static boolean isLeapYear(int y) { 
//		  return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
//	}
//
//	public static int WhichYear_InfiniteLoop(int d) {
//		int days = d;
//		int year = 1970; // 1980;
//		while (days > 365) {
//			if (isLeapYear(year)) {
//				if (days > 366) {
//					days = days - 366;
//					year = year + 1;
//				}
//				else {
//					break;
//				}
//			} else {
//				days = days - 365;
//				year = year + 1;
//			}
//		}
//		return year;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(WhichYear_InfiniteLoop(20));
//		System.out.println(WhichYear_InfiniteLoop(365));
//		System.out.println(WhichYear_InfiniteLoop(366));
//		System.out.println(WhichYear_InfiniteLoop(367));
//		System.out.println(WhichYear_InfiniteLoop(1480));
//		System.out.println(WhichYear_InfiniteLoop(14401));
//		System.out.println(WhichYear_InfiniteLoop(14646));
//	}
//
//}

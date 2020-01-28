package sortPairs;

import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair; 
import java.util.Comparator;
import java.util.Collections;

public class SortPairsTest {

	public static void main(String[] args) {
		List<Pair<String, String>> words = new ArrayList<Pair<String, String>>();
	    words.add(new Pair<String, String>("hello","A"));
	    words.add(new Pair<String, String>("hello","B"));
	    words.add(new Pair<String, String>("aello","C"));

	    Collections.sort(words, new Comparator<Pair<String, String>>() {
	        @Override
	        public int compare(Pair<String, String> o1, Pair<String, String> o2) {
	        	int comp = o1.getKey().compareTo(o2.getKey());
	        	if(comp	 == 0) {
	        		return o1.getValue().compareTo(o2.getValue());
	        	}
	        	
	        	return comp;
	        }
	    });

	    System.out.println(words);	}

}

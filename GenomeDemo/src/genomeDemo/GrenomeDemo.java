package genomeDemo;

import java.util.List;
import java.util.ArrayList;

class Genome {
	private List<Character> sequence;
	
	Genome(String sequence) {
		this.sequence = new ArrayList<Character>();
		for(int i = 0; i < sequence.length(); i++) {
			this.sequence.add(sequence.charAt(i));
		}
	}
	
	List<Character> getSequence() {
		return sequence;
	}
}

public class GrenomeDemo {

	public static void main(String[] args) {
		Genome g = new Genome("ACTGAAA");
		List<Character> l = g.getSequence();
		System.out.println(g.getSequence());
		l.add(2, 'k');
		System.out.println(g.getSequence());
	}

}

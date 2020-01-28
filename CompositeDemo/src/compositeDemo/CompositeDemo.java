package compositeDemo;
// from https://java-design-patterns.com/patterns/composite/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class LetterComposite {
	private List<LetterComposite> children = new ArrayList<>();
	public void add(LetterComposite letter) {
		children.add(letter);
	}
	public int count() {
		return children.size();
	}
	
	protected void printThisBefore() {}
	protected void printThisAfter() {}
	public void print() {
		printThisBefore();
		for (LetterComposite letter : children) {
			letter.print();
		}
		printThisAfter();
	}
}

class Letter extends LetterComposite {
	private char c;
	public Letter(char c) {
		this.c = c;
	}
	@Override
	protected void printThisBefore() {
		System.out.print(c);
	}
}

class Word extends LetterComposite {
	public Word(List<Letter> letters) {
		for (Letter l : letters) {
			this.add(l);
		}
	}
	@Override
	protected void printThisBefore() {
		System.out.print(" ");
	}
}

class Sentence extends LetterComposite {
	public Sentence(List<Word> words) {
		for (Word w : words) {
			this.add(w);
		}
	}
	@Override
	protected void printThisAfter() {
		System.out.print(".");
	}
}

class Messenger {
	LetterComposite messageFromOrcs() {
		List<Word> words = new ArrayList<>();
		words.add(new Word(Arrays.asList(new Letter('W'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
		words.add(new Word(Arrays.asList(new Letter('t'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
		words.add(new Word(Arrays.asList(new Letter('i'), new Letter('s'))));
		words.add(new Word(Arrays.asList(new Letter('a'))));
		words.add(new Word(Arrays.asList(new Letter('w'), new Letter('h'), new Letter('i'), new Letter('p'))));
		words.add(new Word(Arrays.asList(new Letter('t'), new Letter('h'), new Letter('e'), new Letter('r'), new Letter('e'))));
		words.add(new Word(Arrays.asList(new Letter('i'), new Letter('s'))));
		words.add(new Word(Arrays.asList(new Letter('a'))));
		words.add(new Word(Arrays.asList(new Letter('w'), new Letter('a'), new Letter('y'))));
		return new Sentence(words);
	}

	LetterComposite messageFromElves() {
		List<Word> words = new ArrayList<>();
		words.add(new Word(Arrays.asList(new Letter('M'), new Letter('u'), new Letter('c'), new Letter('h'))));
		words.add(new Word(Arrays.asList(new Letter('w'), new Letter('i'), new Letter('n'), new Letter('d'))));
		words.add(new Word(Arrays.asList(new Letter('p'), new Letter('o'), new Letter('u'), new Letter('r'), new Letter('s'))));
		words.add(new Word(Arrays.asList(new Letter('f'), new Letter('r'), new Letter('o'), new Letter('m'))));
		words.add(new Word(Arrays.asList(new Letter('y'), new Letter('o'), new Letter('u'), new Letter('r'))));
		words.add(new Word(Arrays.asList(new Letter('m'), new Letter('o'), new Letter('u'), new Letter('t'), new Letter('h'))));
		return new Sentence(words);
	}
}

public class CompositeDemo {
	public static void main(String[] args) {
		Messenger messenger = new Messenger();
		
		LetterComposite orcMessage = messenger.messageFromOrcs();
		orcMessage.print();
		System.out.println();
		
		LetterComposite elfMessage = messenger.messageFromElves();
		elfMessage.print();
	}

}

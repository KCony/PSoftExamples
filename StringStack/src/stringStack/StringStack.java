package stringStack;

public class StringStack {
	private int maxSize;
	private String [] stack;
	private int top;
	
	public StringStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new String[maxSize];
		this.top = -1;
	}

	public void push(String s) { stack[++top] = s; }
	public String pop() { return stack[--top]; }
	public boolean isempty() { return top == -1; }
	public boolean isfull() { return top == maxSize - 1; }
	
	public static void main(String[] args) {

	}

}

package quiz3;

class Foo {
    private Bar bar;
    public Foo(Bar bar) { this.bar = bar; }
    public void print() { bar.print(); }
}

class Bar {
    private int x;
    public Bar(int x) { this.x = x; }
    public int getVal() { return this.x; }
    public void setVal(int x) { this.x = x; }
    public void print() { System.out.println(x); }
}

public class Quiz3 {

	public static void main(String[] args) {
		Bar b = new Bar(10);
		Foo f = new Foo(b);
		f.print();
		b.setVal(5);
		f.print();
	}
}

package genericEquals;

class Node<E> {
	E label;

	Node(E label) {
		this.label = label;
	}

	// Causes compiler errors 
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Node<E>)) 
//			return false;
//		Node<E> n = (Node<E>) obj;
//		return this.label.equals(n.label);
//	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node<?>)) 
			return false;
//		Node<E> n = (Node<E>) obj;
		Node<?> n = (Node<?>) obj;
		return this.label.equals(n.label);
	}
}

	public class GenericEquals {

		public static void main(String[] args) {
			Node<String> n1 = new Node<String>("aNode");
			Node<String> n2 = new Node<String>("aNode");
			
			System.out.println(n1.equals(n2));
		}

	}

package treeDemo;

/* TreeNode represents a node in a binary tree. */ 
class TreeNode {
	private int key;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int key, TreeNode left, TreeNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	public int key() { return key; }
	public TreeNode left() { return left; }
	public TreeNode right() { return right; }

	public void accept(Visitor v) {
		if(left != null) left.accept(v);
		if(right != null) right.accept(v);
		v.visit(this);
	}
}

interface Visitor {
	public void visit(TreeNode t);
}

class HeightVisitor implements Visitor{
	// rep: 
	// recurDepth - recursion depth of tree search
	// height - the maximum tree depth

	private static int height = 0;
	private static int recurDepth = 0;

	public int getHeight() {
		return height;
	}

	public void visit(TreeNode t) {
		if (t.left() != null) {
			recurDepth++;
			if (recurDepth > height)
				height = recurDepth;
			t.left().accept(this);
			recurDepth--;
		}

		if (t.right() != null) {
			recurDepth++;
			t.right().accept(this);
			if (recurDepth > height)
				height = recurDepth;
			recurDepth--;
		}
	}

}

public class TreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3, 
				new TreeNode(2,
						new TreeNode(1,new TreeNode(7, null, null),null),
						null
						),
				//                new TreeNode(4,null,null)
				new TreeNode(4, new TreeNode(5, new TreeNode(6, null, null), null),null)
				);

		HeightVisitor h = new HeightVisitor();
		root.accept(h);
		System.out.println("====");		
		System.out.println(h.getHeight());
	}

}

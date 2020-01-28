package treeDemo2;

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
		v.visit(this);
	}
}

interface Visitor {
	public void visit(TreeNode t);
}

class NodeCountVisitor implements Visitor {
	private int nodeCount = 0;
//	private int recur = 0;

	int getNodeCount() {
		return nodeCount;
	}
	
	public void visit(TreeNode t) {
//		if(t == null)
//			return;
		
		if(t.left() != null)
			t.left().accept(this);
		if(t.right() != null)
			t.right().accept(this);	
		nodeCount++;
		

		// this works but isn't Visitor pattern
//		nodeCount++;
//		if(t.left() != null)
//			visit(t.left());
//		if(t.right() != null)
//			visit(t.right());	

		// count incorrect
//		nodeCount++;
//		if(t.left() != null) {
//			nodeCount++;
//			visit(t.left());
//		}
//		if(t.right() != null) {
//			nodeCount++;
//			visit(t.right());
//		}

		// This only woks if you check for null above
//		visit(t.left());
//		visit(t.right());

//		nodeCount = 0;
//		while(t.left() != null && t.right() != null) {
//			if(t.left() != null)
//				nodeCount++;
//			if(t.right() != null)
//				nodeCount++;	
//		}
		
		// ifinite loop
//		nodeCount = 0;
//		while(t.left() != null) { 
//			nodeCount++;
//			visit(t.left());
//		}
//		while(t.right() != null) {
//			nodeCount++;
//			visit(t.right());
//		}

		
//		if(t.left() != null) {
//			nodeCount++;
//			visit(t.left());
//			// t.left().accept(this);
//		}
//		if(t.right() != null) {
//			nodeCount++;
//			visit(t.right());
//			// t.right().accept(this);
//		}
		
//		if(t == null)
//			return;
//		else {
//			if(nodeCount == recur) {
//				nodeCount = 0;
//				recur = 0;
//			}
//			nodeCount++;
//			visit(t.left());
//			visit(t.right());
//			recur += 2;
//		}

//		if(t.left() == null && t.right() == null)
//			nodeCount++;
//		else {
//			visit(t.left());
//			nodeCount++;
//			visit(t.right());
//			nodeCount++;
//		}
		
//		if(t != null) {
//			nodeCount++;
//			visit(t.left());
//			visit(t.right());
//		}
		
//		if(t.left() == null) 
//			nodeCount++;
//		if(t.right() == null) 
//			nodeCount++;
//		visit(t.left());
//		visit(t.right());
	} 
}

public class TreeDemo2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, 
				new TreeNode(2,
						new TreeNode(1,null,null),
						null
						),
				new TreeNode(4,null,null)
				);

//				TreeNode root = new TreeNode(3, 
//								new TreeNode(2,
//								new TreeNode(1,new TreeNode(7, null, null),null),
//								null
//								),
		//				//                new TreeNode(4,null,null)
		//				new TreeNode(4, new TreeNode(5, new TreeNode(6, null, null), null),null)
//						);

		NodeCountVisitor h = new NodeCountVisitor();
		root.accept(h);
		System.out.println("====");		
		System.out.println(h.getNodeCount());		
	}

}

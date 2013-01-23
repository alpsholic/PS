package problems;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

public class InorderReverse {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	

	public void inOrder(TreeNode root){
		if (root == null) {System.out.print("# ");return;}
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
	
	public void inOrderRev(TreeNode root){
		if (root == null){
			System.out.print("# ");
			return;
		}
		inOrderRev(root.right);
		System.out.print(root.val+" ");
		inOrderRev(root.left);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		root.right = node1;
		node1.left=node2;
		InorderReverse bst = new InorderReverse();
		bst.inOrder(root);
		System.out.println();
		bst.inOrderRev(root);
		

	}

}

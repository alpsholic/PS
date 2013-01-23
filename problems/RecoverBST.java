package problems;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

public class RecoverBST {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	TreeNode node1 = null, node2 = null,  prevNode = null;
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		inOrderPrint(root);
		System.out.println();
		inOrder(root);
		prevNode = null;
		inOrderRev(root);
		int t = node1.val;
		if (node2 == null){
			node2= root;
		}
		node1.val = node2.val;
		node2.val = t;
		inOrderPrint(root);
		System.out.println();
	}

	public void inOrder(TreeNode root){
		if (root == null) {return;}
		inOrder(root.left);
		if (prevNode != null){
			if (prevNode.val > root.val){
				if (node1 == null){node1 = prevNode;}
				else node2 = prevNode;
			}
		}
		prevNode = root;		
		inOrder(root.right);
		if (prevNode != null){
			if (prevNode.val < root.val){
				if (node1 == null){node1 = prevNode;}
				else node2 = prevNode;
			}
		}
		prevNode = root;
	}
	
	public void inOrderRev(TreeNode root){
		if (root == null) {return;}			
		inOrderRev(root.right);
		if (prevNode != null){
			if (prevNode.val < root.val){
				if (node1 == null){node1 = prevNode;}
				else node2 = prevNode;
			}
		}
		prevNode = root;
		inOrderRev(root.left);
		if (prevNode != null){
			if (prevNode.val > root.val){
				if (node1 == null){node1 = prevNode;}
				else node2 = prevNode;
			}
		}
		prevNode = root;	
	}
	
	public void inOrderPrint(TreeNode root){
		if (root == null) {System.out.print("# ");return;}
		inOrderPrint(root.left);
		System.out.print(root.val+" ");
		inOrderPrint(root.right);
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
		RecoverBST bst = new RecoverBST();
		bst.recoverTree(root);

	}

}

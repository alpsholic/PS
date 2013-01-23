package problems;

/*
 * Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class ValidateBST {

	TreeNode prevNode = null;
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) return true;
		if (isValidBST(root.left) == false) return false;
		if ((prevNode != null)&&(prevNode != root)){
			if (prevNode.val >= root.val){
				return false;
			}
		}
		prevNode = root;

		if (isValidBST(root.right) == false) return false;
		if ((prevNode != null)&&(prevNode != root)){
			if (prevNode.val <= root.val){
				return false;
			}
		}
		prevNode = root; 
		return true;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeNode root = new TreeNode(1);
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(2);
//		root.right = node1;
//		node1.left=node2;
//		TreeNode root = new TreeNode(10);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node15 = new TreeNode(15);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node20 = new TreeNode(20);
//		
//		root.left = node5; root.right=node15;
//		node15.left=node6; node15.right=node20;
		
		//{3,1,5,0,2,4,6,#,#,#,3}	
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node0 = new TreeNode(0);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node3= new TreeNode(3);
		
		root.left=node1; root.right = node5;
		node1.left= node0; node1.right = node2;
		node5.left = node4; node5.right=node6;
		node4.right = node3;
		
		ValidateBST bst = new ValidateBST();
		System.out.println(bst.isValidBST(root));

	}

}

package problems;

public class MaximumSumPath {
	

	static int MIN = -1000;
	static int max = MIN;

	public static int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		maxPathSum2(root);
		return max;
	}
	
	public static int maxPathSum2(TreeNode root){
		if (root == null) return MIN;

		int left = maxPathSum2(root.left);
		int right = maxPathSum2(root.right);

		max = Math.max(max,
				Math.max(Math.max(Math.max(left,right),root.val),left+right+root.val));

		return Math.max(left+root.val,right+root.val);    
	}
	
	public static void main (String args[]){
		TreeNode root = new TreeNode(-3);
		
		System.out.println(maxPathSum(root));
	}
	

}



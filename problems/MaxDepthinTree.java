
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        max = Integer.MIN_VALUE;
        maxDepth(root,0);
        return max;        
    }
    
    public void maxDepth(TreeNode root, int i){
        if (root == null) {
            max = Math.max(max,i);
        }
        else
        {
            maxDepth(root.left,i+1);
            maxDepth(root.right,i+1);
        }
    }
}

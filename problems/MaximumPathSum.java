/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    
    int MIN = -1000;
    int max = MIN;
    
    public int maxPathSum(TreeNode root) {
         MIN = -1000;
         max = MIN;
        // Start typing your Java solution below
        // DO NOT write main() function
        maxPathSum2(root);
        return max;      
    
        
    }
    
    public int maxPathSum2(TreeNode root){
        if (root == null) return MIN;
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        
        max = Math.max(max,
               Math.max(Math.max(Math.max(left,right),root.val),left+right+root.val));
               max=Math.max(max,root.val+Math.max(left,right));
               
        return Math.max(root.val, Math.max(left+root.val,right+root.val));    
    }
}

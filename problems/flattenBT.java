/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
» Solve this problem
*/
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (root == null) return;
        if ((root.left == null)&&(root.right==null)) return;
        flatten(root.left);     
        flatten(root.right);
           
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode templ = root;
        while (templ.right != null){
            templ = templ.right;            
        }
        templ.right = temp;
    }
}

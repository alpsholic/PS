/*
/**
         1
        / \
       2   5
      / \   \
     3   4   6
     
     prints.. 3,4,6;2,5;1
**/

*/

public class Solution{
    public static void revBFS(TreeNode node){
        String ans = "";
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            ans = ","+curr.val+ans;
            if(curr.right!=null) q.add(curr.right);
            if(curr.left!=null) q.add(curr.left);
        }
        System.out.println(ans.substring(1));
    }

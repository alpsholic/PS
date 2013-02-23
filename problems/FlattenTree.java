package problems;

public class FlattenTree {
	
	// Given a binary tree, flatten it to a linked list in-place.

	// For example,
	// Given

//	          1
//	         / \
//	        2   5
//	       / \   \
//	      3   4   6
	// The flattened tree should look like:
//	    1
//	     \
//	      2
//	       \
//	        3
//	         \
//	          4
//	           \
//	            5
//	             \
//	              6
	
	    public void flatten(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        st =   new Stack<TreeNode>();  
	        ft(root);        
	        TreeNode rc = null;
	        while(!st.empty()) {
	                        if (rc == null) {
	                                rc = st.pop();
	                        } else {
	                                TreeNode p = st.pop();
	                                p.left = null;
	                                p.right = rc;
	                rc = p;
	                        }
	                }
	    }
	    static Stack<TreeNode> st;
	    
	    public static void ft(TreeNode n) {
	        if (n == null)  return;       
	        
	        st.push(n);
	        ft(n.left);        
	        ft(n.right);        
	    }
	}

}

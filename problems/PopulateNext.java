package problems;

public class PopulateNext {

	
	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */

	    public void connect(TreeLinkNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Queue<TreeLinkNode> l = new LinkedList<TreeLinkNode>();
	        l.add(root);
	        cnq(l);
	        return;
	    }
	    
	    public static void cnq(Queue<TreeLinkNode> q) {        
	        int cq = q.size();
	        if (cq == 0) return;
	        Queue<TreeLinkNode> qn = new LinkedList<TreeLinkNode>();
	        TreeLinkNode p = q.poll();
	        
	        while(p != null) {
	            if(p.left != null) qn.add(p.left);
	            if(p.right != null) qn.add(p.right);
	            p.next = q.peek();
	            p = q.poll();               
	        }           
	        cnq(qn);      
	        return;
	    }
	}
}

package problems;

public class PartitionList {
	
	// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

	// You should preserve the original relative order of the nodes in each of the two partitions.

	// For example,
	// Given 1->4->3->2->5->2 and x = 3,
	// return 1->2->2->4->3->5.

	
	    public ListNode partition(ListNode n, int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(n== null) return n;
	        
	        ListNode on = n;
	        ListNode s = null;
	                ListNode e = null;
	                ListNode p = null;
	                
	                while (n != null) {
	                        if (n.val >= x) {
	                                if(s == null) {
	                                        s = n; 
	                                        e = n;                                  
	                                } else {                                
	                                        e.next = n;
	                                        e = e.next;                                     
	                                }
	                                if ( p!= null) p.next = n.next;                         
	                                 else on = on.next;
	                                
	                        } else p = n;                                   
	                                                
	                        n = n.next;
	                }
	                
	                if (s != null) {
	                        e.next = null;
	                        if (p == null) return s;                        
	                        else p.next = s;        
	                }
	                
	                return on;
	        
	    }
	}

}

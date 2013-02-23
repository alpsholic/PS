package problems;

public class SortedArrayToBST {
	
	// Convert Sorted Array to Binary Search Tree
	// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	public class Solution {
	    public TreeNode sortedArrayToBST(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(num.length == 0) return null;
	        if(num.length == 1) return new TreeNode(num[0]);
	        return atotree(num,0,num.length-1);
	        
	    }
	    public static TreeNode atotree(int[] a, int s, int e) {     
	                if (s==e) return new TreeNode(a[s]);
	                if (s>e) return null;
	                
	                /* m =  s+(e-s)/2; // when there are odd no. of elements                                        
	                   m = (s+(e-s)/2)+1; // when there are even no. of elements 
	                 */             
	                int m = ((e-s) % 2 == 0) ? s+(e-s)/2 : (s+(e-s)/2)+1; 

	                TreeNode mNode = new TreeNode(a[m]);
	                mNode.left = atotree(a, s, m-1);
	                mNode.right = atotree(a, m+1,e);
	                return mNode;   
	        }
	}

}

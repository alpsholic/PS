package problems;

public class JumpGame2 {
	
	// Given an array of non-negative integers, you are initially positioned at the first index of the array.

	// Each element in the array represents your maximum jump length at that position.

	// Your goal is to reach the last index in the minimum number of jumps.

	// For example:
	// Given array A = [2,3,1,1,4]

	// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


	
	    public int jump(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        return jg2(A);
	    }
	    
	    public static int jg2(int[] a) {
	        int[] jumps = new int[a.length];                
	                jumps[a.length-1] = 0;
	                for(int i = a.length-2; i >= 0; i--) {
	                        if (a[i] != 0) jumps[i] = findMin(jumps, i+1, Math.min(i+a[i], a.length-1)) + 1;                                        
	                        else jumps[i] = a.length;               
	                }
	                return (jumps[0] > a.length? a.length: jumps[0]);               
	        }       
	        
	        public static int findMin(int[] j, int s, int e) {
	                int m = Integer.MAX_VALUE;              
	                for (int i=s; i <=e; i++) if (j[i] < m) m = j[i];       
	                return m;
	        }
	}


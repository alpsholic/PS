package problems;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution1 {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int in  = (int)Math.pow(2,A.length-1);
        for (int i = 0; i < A.length; i++){
            int temp = in & (1 << (A.length-1-i));
            if (temp == 0) continue;
            
            int k = Math.min(A.length-1, A[i]+i);
            in = in | (((int)(Math.pow(2,A[i])-1)) << (A.length-1-k));
        }
         in = in & 1;
         if (in == 0) return false;
         return true;
    }       
}

public class Solution2 {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int in  = (int)Math.pow(2,A.length-1);
        for (int i = 0; i < A.length; i++){
            int temp = in & (1 << (A.length-1-i));
            if (temp == 0) continue;
            
            int k = Math.min(A.length-1, A[i]+i);
            in = in | (((int)(Math.pow(2,A[i])-1)) << (A.length-1-k));
        }
         in = in & 1;
         if (in == 0) return false;
         return true;
    }       
}
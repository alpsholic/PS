package problems;

public class ClimbingStairs {
	
	// You are climbing a stair case. It takes n steps to reach to the top.
	//
	// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	// Only passes for small cases. Not optimal
	public class Solution {
	    public int climbStairs(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        count = 0;
	        cs(0,n);
	        return count;
	        
	    }
	    int count;
	    public void cs(int s, int n) {
	        if (s == n) {
	            count = count + 1;
	            return;
	        } else if (s > n) {
	            return;            
	        }
	        
	        cs(s+2,n);
	        cs(s+1,n);
	    }
	}

	// Its just fibonaci series!
	
	public
	    int climbStairs(int n) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function
	        
	        int l1 = 1;
	        int l2 = 2;
	        int l3;
	        if (n == 1) return l1;
	        if (n == 2) return l2;
	        
	        for(int i=3; i <= n; i++) {
	            l3 = l1 + l2;
	            l1 = l2;
	            l2 = l3;            
	        }
	        
	        return l3;
	        
	    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

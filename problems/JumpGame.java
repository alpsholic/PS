package problems;

public class JumpGame {
	
	
	    public boolean canJump(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        
	        return jg(A);
	        
	    }
	    
	    public static boolean jg(int[] a) {         
	                int lp = a.length-1;
	                for(int i = a.length-2; i >= 0; i--) if (i+a[i] >= lp)  lp = i;
	                if (lp == 0) return true;
	                return false;           
	        }    
	    
	}



package problems;

public class InterleavedStrings {
	
	// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	//
	// For example,
	// Given:
	// s1 = "aabcc",
	// s2 = "dbbca",
	//
	// When s3 = "aadbbcbcac", return true.
	// When s3 = "aadbbbaccc", return false.
	//
	// Uses dynamic programming:
	// Let I(l,m) be the function that returns true or false if the strings s1 (of length l) and 
	// s2 (of length m) are interleaved correctly or not.
	// If I(l,m) = I(l-1,m) if s1[l] == s3[l+m]
//	           = I(l,m-1) if s1[m] == s3[l+m]
//	           = (I(l-1,m) || I(l,m-1)) if s1[l] == s3[l+m] and s1[m] == s3[l+m]
	// 
	
	    public boolean isInterleave(String s1, String s2, String s3) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        
	        if(s1.length() + s2.length() != s3.length()) return false;
	        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
	        
	        int l = s1.length()+1;
	        int m = s2.length()+1;  
	                
	                int[][] t = new int[l][m];
	                
	                for(int i=1; i < l;i++) {
	                        if (c(s3,i-1) == c(s1,i-1)) t[i][0] = 1;
	                }
	                
	                for(int j=1; j < m;j++) {
	                        if (c(s3,j-1) == c(s2,j-1)) t[0][j] = 1;
	                }
	                
	                for(int i=1; i < l; i++) {
	                        for (int j=1; j < m; j++) {                             
	                                if (c(s3,i+j-1) == c(s1,i-1) && c(s3,i+j-1) == c(s2,j-1)) {
	                                        if (t[i-1][j] == 1 || t[i][j-1] == 1) {
	                                                t[i][j] = 1;
	                                        } else {
	                                           t[i][j] = 0; 
	                                        }
	                                } else if (c(s3,i+j-1) == c(s1,i-1)) {
	                                        t[i][j] = t[i-1][j];
	                                } else if (c(s3,i+j-1) == c(s2,j-1)) {
	                                        t[i][j] = t[i][j-1];
	                                }                               
	                        }
	                }
	        
	        if (t[l-1][m-1] == 1) {
	            return true;
	        }
	        return false;
	        
	    }        
	    
	    public static char c(String s, int i) {
	        return s.charAt(i);
	        }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

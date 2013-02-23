package problems;

public class ScrambleString2 {
	// Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

	// Below is one possible representation of s1 = "great":

//	     great
//	    /    \
	//   gr    eat
	//  / \    /  \
	// g   r  e   at
//	            / \
//	           a   t
	// To scramble the string, we may choose any non-leaf node and swap its two children.

	// For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

//	     rgeat
//	    /    \
	//   rg    eat
	//  / \    /  \
	// r   g  e   at
//	            / \
//	           a   t
	// We say that "rgeat" is a scrambled string of "great".

	// Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

//	     rgtae
//	    /    \
	//   rg    tae
	//  / \    /  \
	// r   g  ta  e
//	        / \
//	       t   a
	// We say that "rgtae" is a scrambled string of "great".

	// Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

	// Solution: Here the assumption is that the strings has one and only one split
	// point. There is one case on leetcode that does not have this assumption, therefore only
	// for that case this solution does not work. A backtracking kind of solution, which
	// explores all the ways of spliting, if there are more than one, would be better.

	public class Solution {
	    public boolean isScramble(String s1, String s2) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        res = true;
	        findScramble(s1, s2);           
	        return res;
	    }
	    boolean res;
	    public void findScramble(String s, String d){
	        // check the code here.
	                if (s.length() == 2) {
	                        char cs1 = s.charAt(0);
	                        char cs2 = s.charAt(1);
	                        char cd1 = d.charAt(0);
	                        char cd2 = d.charAt(1);
	                        if (!((cs1 == cd1 && cs2 == cd2) || (cs1 == cd2 && cs2 == cd1))){
	                                res = false;
	                                //System.out.println("false");
	                                                
	                        }
	                        return;                 
	                }
	                
	                if (s.length() == 1) {
	                        if (s.charAt(0) != d.charAt(0)) {
	                                res = false;
	                                //System.out.println("false");
	                                                
	                        }
	                        return;                 
	                }
	                
	                int mid; 
	                
	                mid = findSplitPoint(s, d, false);
	                
	                if (mid != -1 && res == true) {
	                        if (mid != s.length()-1) {                              
	                                String sl =     s.substring(0,mid+1); 
	                                String sr = s.substring(mid+1);
	                                String dl = d.substring(0,mid+1);
	                                String dr = d.substring(mid+1);
	                                //System.out.println("sl:"+sl+" sr:"+sr+" dl:"+dl+" dr:"+dr);
	                                findScramble(sl, dl);                           
	                                findScramble(sr, dr);                           
	                        }                       
	                } else {                
	                        mid = findSplitPoint(s, d, true);
	                        if (mid != -1 && res == true) {
	                                if (mid != s.length()-1) {                              
	                                        String sl =  s.substring(0,mid+1);                                       
	                                        String sr = s.substring(mid+1);
	                                        String dl = d.substring(0,s.length()-mid-1);
	                                        String dr = d.substring(s.length()-mid-1);
	                                        //System.out.println("sl:"+sl+" sr:"+sr+" dl:"+dl+" dr:"+dr);
	                                        findScramble(sl, dr);                           
	                                        findScramble(sr, dl);
	                                }
	                        
	                        } else {
	                         res = false;
	                        }
	                }               
	                return;
	                
	        }
	    
	    public int findSplitPoint(String s, String d, boolean reverse) {
	        int strSize = s.length()-1;
	                int[] sp = new int[26]; // check size later
	                int[] dp = new int[26];
	                
	                boolean isStarted = false;
	                boolean allSeen = false;
	                int splitPoint = -1;
	                int equalUntil = -1;
	                int tsp = 0;
	                int tdp = 0;            
	                
	                for(int i = 0; i <= strSize; i++) {
	                        int sc = (int) s.charAt(i);
	                        int dc = (reverse) ? (int) d.charAt(strSize-i) : (int) d.charAt(i);                     
	                        sc = sc - 97;
	                        dc = dc - 97;
	                        if (sc != dc) {
	                                if (isStarted == false) isStarted = true;
	                                if (dp[sc] > 0) {
	                                        dp[sc]--;
	                                        tdp--;
	                                } else {
	                                        sp[sc]++;
	                                        tsp++;
	                                }
	                                
	                                if (sp[dc] > 0) {
	                                        sp[dc]--;
	                                        tsp--;
	                                } else {
	                                        dp[dc]++;
	                                        tdp++;
	                                }
	                                
	                                if (tdp == 0 && tsp == 0 && i != strSize) {
	                                        //System.out.println(i);
	                                        splitPoint = i;
	                                }                                                       
	                                
	                        } else if (isStarted == false) {
	                                equalUntil = i;
	                        }                       
	                }
	                
	                if (tdp == 0 && tsp == 0) {
	                        allSeen = true;
	                }
	                
	                if (allSeen == true) {                  
	                        if (equalUntil > splitPoint) {
	                                return equalUntil;
	                        } else {
	                                //System.out.println("here");
	                                return splitPoint;
	                        }
	                } else {
	                        return -1;
	                }       
	                
	        }
	}

}

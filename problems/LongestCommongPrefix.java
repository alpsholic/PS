package problems;

public class LongestCommongPrefix {
	
	
	    public String longestCommonPrefix(String[] strs) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (strs.length == 0) return "";
	        return lcp(strs);
	        
	    }
	    
	    public static String lcp(String[] strs) {
	        String s = strs[0];             
	                for(int i=1; i < strs.length; i++) {
	                        if (s == "") {
	                                return s;
	                        } else {
	                                String s1 = strs[i];
	                                for(int j=0; j < Math.min(s1.length(),s.length()); j++) {
	                                        if (s.charAt(j) != s1.charAt(j)) {
	                                                s = s.substring(0,j);
	                                                break;
	                                        }
	                                }                               
	                                if(s1.length() < s.length()) s = s1;    
	                        }
	                        
	                }
	                return s;
	                
	        }
	}



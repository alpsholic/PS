package problems;

public class LengthOfLastWord {
	// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

	// If the last word does not exist, return 0.

	// Note: A word is defined as a character sequence consists of non-space characters only.

	// For example, 
	// Given s = "Hello World",
	// return 5.
	
	    public int lengthOfLastWord(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int len = 0;
	        Stack<Character> ts = new Stack<Character>();
	        
	                for(int i = 0; i <= s.length(); i++) {
	                        if(i == s.length() || s.charAt(i) == ' ') {
	                                if(!ts.empty()) {
	                                        len = 0;
	                                        while(!ts.empty()) {
	                                                ts.pop();
	                                                len = len+1;
	                                        }
	                                }
	                        } else {
	                                ts.push(s.charAt(i));
	                        }
	                        
	                }
	        return len;
	    }
	}



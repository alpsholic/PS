package problems;

import java.util.HashMap;

/*
 * Scramble String
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();

		for(int i = 0; i < s2.length(); i++){
			map.put(s2.charAt(i), i);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean ans = true;
		//split location 1 to len-1
		for (int i = 1; i < s1.length(); i++ ){
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int j = 0 ; j < i; j++){
				int loc = map.get(s1.charAt(j));
				min = Math.min(min, loc);
				max = Math.max(max,loc);
			}
			int size1 = max-min+1;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int j = i; j < s1.length(); j++){
				int loc = map.get(s1.charAt(j));
				min = Math.min(min, loc);
				max = Math.max(max,loc);
			}
			int size2 = max-min+1;
			if ((size1 + size2) == s1.length()){
				System.out.println("true for split= "+i);
				//return (isScramble(s1.substring(0,i), s2.substring(0, i))&(isScramble(s1.substring(i,s1.length()), s2.substring(i, s2.length()))));
				return true ;
			}

		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScrambleString s = new ScrambleString();
		System.out.println(s.isScramble("abcde", "ecadb"));

	}

}

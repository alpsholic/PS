package problems;

import java.util.HashMap;

/*
 * Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringNoRepeats {

	public int lengthOfLongestSubstring(String s) {		
		int max = 0;
		//Integer to see where to start after a repetition is found
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		int len = 0;
		for (int i = 0; i < s.length(); ){
			Character ch = s.charAt(i);
			if (!map.containsKey(ch)){
				map.put(ch, i);
				len++;
				max = Math.max(len, max);
				i++;
			}else{
				max = Math.max(len, max);
				//repetition
				i = map.get(ch)+1;
				map.clear();
				//map.remove(ch);
				len = 0;
			}			
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringNoRepeats c = new LongestSubstringNoRepeats();
System.out.println(c.lengthOfLongestSubstring("abcddcbae"));
	}

}

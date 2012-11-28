package problems;
/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists 
 * one unique longest palindromic substring.
 */
import java.util.Stack;

public class LongestPalindromeSubString {
	int curBegin = -1, curEnd = -1;
	int curLen = -1;
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		curBegin = -1 ; curEnd = -1;
		curLen = -1;
		if (s.length() == 1) return s;
		int diff[] = new int[s.length()-1];
		/*
	store the differences between successive characters. So the problem translates to
	finding longest subarray with a sum zero!
	"cabbad" translates to [-3,1,0,-1,4]. So answer is 1,0,-1 longest subbarray with zero sum.
	because i store only successive ascii difference- so one less

	... is there a standard solution for this problem: finding longest subarray with a sum zero?
	I dont know. I invented the solution. It works fine except 1-2 cases! 

	LOGIC: In terms of the differences, any polindrome should look like: some ups ("ab") and downs ("ba") and flats ("aa").
	So flat behavior (corresponding entries are zeros in the array) should also be tracked.
	Sometimes, a polindrome is simply a flat array ("caaaad"=>"aaaa").


	wht is the logic of keeping track of numZeros?

	Interesting approach
	try to see if you can comment on the complexity? complexity- numOfpolindromes*size of polindromes

	Also.. why is it failing.. is it bcoz of timeout? or wrong answers?: wrong answer, with some boundary cases. 
	I can fix it.
		 */
		for (int i = 0; i < s.length()-1; i++){
			diff[i] = s.charAt(i+1)-s.charAt(i);			
		}

		int numZeros = 0; 
		for (int i = 1; i< diff.length;i++){

			if (diff[i] == 0){				
				numZeros++;				
				updateStats(i-numZeros-1,i+1);				
			}
			else{
				boolean temp = false;
				/*
	                catch first appearance of a polindrome..ith element plus 
	                previous non-zero element should sum to zero
				 */
				if (diff[i] + diff[i-numZeros-1] == 0){
					temp = true;
					//palindrome caught
					int begin = i-numZeros-1, end =i;
					while (true){
						if (diff[begin]+diff[end] == 0){
							begin--; end++;

							if ((begin < 0) || (end > diff.length-1)){
								updateStats(begin,end);
								numZeros = 0;
								break;
							}
						}else{
							//not zero..palindrome broke..curPali is begin+1, end-1
							if ((begin < 0) &&(end == diff.length)){
								return s;
							}
							updateStats(begin,end);
							numZeros = 0;
							break;						
						}
					}

				}else{
					/*
	                    the poli detected is a string of equal characters
	                    like "aaa" or "bbb"
					 */
					if (temp == false){
						if (curLen < numZeros){
							curLen = numZeros;
							curBegin = i-numZeros;
							curEnd = i-1;
						}


					}				
				}
				numZeros = 0;
			}			
		}

		if (curBegin == -1) return null;
		return s.substring(curBegin,curEnd+2);

	}
	public void updateStats(int begin, int end){
		int p = begin+1, q = end-1; 
		if (curLen < q-p+1){
			curLen = q-p+1;
			curBegin = p; curEnd = q;		
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeSubString l = new LongestPalindromeSubString();
		//System.out.println(l.getLongPal("abaddaba"));
		//System.out.println(l.getLongPal("cabaxddabad"));
		//System.out.println(l.getLongPal("daaac"));
		//System.out.println(l.getLongPal("aaaabbccccc"));
		System.out.println(l.longestPalindrome("aabbaa"));

	}

}

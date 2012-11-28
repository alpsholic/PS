package problems;

import java.util.Stack;
/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class LongParenthesis {

	public int getLongestParenthesis(String s){
		boolean v[] = new boolean[s.length()];
		for (int i =0;i < s.length();i++){
			v[i] = false;
		}
		Stack<String> st = new Stack<String>();
		Stack<Integer> st2 = new Stack<Integer>();
		int len = 0; int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i)=='('){
				st.push("(");
				st2.push(i);
			}
			if (s.charAt(i) == ')'){
				if (st.isEmpty()){
					continue;
				}
				if (st.pop().charAt(0) == '('){
					v[i] = true;
					v[st2.pop()] = true;					
				}
			}
		}
		for (int i = 0;i<s.length();i++){
			if (v[i]){
				len++;
			}else{
				len = 0;				
			}
			max= Math.max(max, len);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongParenthesis c = new LongParenthesis();
		System.out.println(c.getLongestParenthesis(")()())"));
		System.out.println(c.getLongestParenthesis("(()"));
	}

}

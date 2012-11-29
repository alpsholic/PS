/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/


public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        boolean[] v = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                v[i]=v[st.pop()]=!st.isEmpty();
            }
        }
        int ans=0,tmp=0;
        for(boolean b:v){
            if(b) tmp++;
            else{
                ans = Math.max(ans,tmp);
                tmp=0;
            }
        }
        return Math.max(ans,tmp);
    }
}


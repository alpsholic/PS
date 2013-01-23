/* Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/


public class Solution {
    public int maxProfit(int[] s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ans = 0,minSoFar=100000;
        for(int i=0;i<s.length;i++){
            minSoFar = Math.min(minSoFar,s[i]);
            ans = Math.max(ans,s[i]-minSoFar);
        }
        return ans;
        
    }
}

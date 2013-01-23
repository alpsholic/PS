/* Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

*/


***** with recursion *******


public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        return maxProfit(prices,0,prices.length);
        
    }
    
    public int maxProfit(int[] prices, int start, int end){
        // DO NOT write main() function
        if (start == end) return 0;
        if (start > end) return 0;
        
        int maxPrice = Integer.MIN_VALUE; //KEKA CONST :D
        
        for (int i = start; i < end; i++){
            if (maxPrice < prices[i]){
                maxPrice = prices[i];
            }
        }
        
        
        int min = Integer.MAX_VALUE;
        
     int i = start;
        for (; i < end; i++)
        {
            if (prices[i] < min) {
                min = prices[i];
            }
            
            if (prices[i] == maxPrice){
            break;
                
            }
        }
        return Math.max(maxPrice-min,maxProfit(prices,i+1,end));                
    }
}



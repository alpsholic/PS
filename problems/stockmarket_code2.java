/*

Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

*/




public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
                
        int curProfit = 0;
        int start = 0, end = prices.length;
        while (true){
        int maxPrice = findMax(prices, start, end);
            int minPrice = Integer.MAX_VALUE; 
            int i = start;
        for (; i < end; i++){
            if (prices[i] == maxPrice){
              minPrice = findMin(prices,start,i);
              if (curProfit < maxPrice-minPrice){
              curProfit = maxPrice-minPrice;
              
              }             
              break;
            }
        }
        
        if (i== end){
        break;
        }else{
        start = i+1;        
        }         
        
        }
        return curProfit;
    }
    
    
    public int findMax(int[] a,  int start, int end){
       int max = Integer.MIN_VALUE;
       for (int i = start; i < end; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
       return max;
    }
    
    public int findMin(int[] a,  int start, int end){
       int min = Integer.MAX_VALUE;
       for (int i = start; i < end; i++){
            if (min > a[i]){
                min = a[i];
            }
        }
       return min;
    }    
}

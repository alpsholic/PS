package problems;

public class MaxProfit {


	int max = -100000;
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int a[] = new int[prices.length];
		for(int i = 0; i < prices.length; i++){
			a[i] = i;
		}
		if (prices.length == 1) return 0;
		if (prices.length == 2) {
           int profit = prices[1]-prices[0];
           return ((profit < 0)?0:profit);
		}
		if (prices.length == 3){
			int profit = Math.max(Math.max(prices[1]-prices[0], prices[2]-prices[0]),prices[2]-prices[1]);
			return ((profit < 0)?0:profit);
		}
		allPerms(a,0,prices);
		return max;
	}

	public void allPerms(int a[], int loc,int prices[]){

		if (loc == a.length-1) {
			//take first 4
			if ((a[0]<a[1]) && (a[1]<a[2]) && (a[2]<a[3])){
				max = Math.max(max,prices[a[1]]-prices[a[0]]+prices[a[3]]-prices[a[2]]);
			}             

		}
		else for (int j = loc; j < a.length; j++){
			//swap a[loc] and a[j]
			int tmp = a[loc]; a[loc]=a[j];a[j]=tmp;
			allPerms(a,loc+1,prices);
			tmp = a[loc]; a[loc]=a[j];a[j]=tmp;			
		} 

	}
}


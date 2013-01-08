package problems;

/*
 * algo course- Nishanth prof.
 * You are given n distinct points on a line (say on the x axis). Design an algorithm in O(n3) to
ﬁnd a path to visit all points such that the summation of the delay for each point is minimized.
The delay for a point pi, with respect to a path P, is the total length of the subpath in P from the
beginning of the path to the ﬁrst arrival at pi.
For example, assume you are given 5 points with coordinates 0, 9, 10, 11 and 20. If the path
starts at 11, moves to 0, and then reverses direction to move to 20, then the delay is 0 for point
11, 1 for point 10, 2 for point 9, 11 for point 0, and 31 for point 20, for a total delay of 45—you
can verify that this is the optimal total delay.

Here the solution is O(n^2) only. No dynamic programming!
 */
public class DP{

	public int solve(int[] X){
		int ans = Integer.MAX_VALUE;
		int N=X.length-1;
		for(int i = 0;i<=N;i++){//Trying out all starting points
			int currLR = 0,currRL=0;//s_L_R,s_R_L
			for(int j = 0;j<=N;j++){
				currLR += (i>j)?X[i]-X[j]:X[j]-X[0]+X[i]-X[0];
				currRL += (i>j)?X[N]-X[i]+X[N]-X[j]:X[j]-X[i];
			}
			ans = Math.min(ans,Math.min(currLR,currRL));
		}
		return ans;
	}
	public static void main(String[] args) {
		DP dp = new DP();
		System.out.println(dp.solve(new int[]{0,9,10,11,20}));
		System.out.println(dp.solve(new int[]{0,9,10}));
	}
}

//    public int getMinDelay(int in[]){
//        int min = Integer.MAX_VALUE;
//        int l2rdelay = 0;
//        int r2ldelay = 0;
//        //compute left to right delay-- path is stratightline
//        for (int i = 0; i < in.length; i++){
//            l2rdelay += in[i] - in [0];            
//        }
//        
//        //compute right to left delay-- straighline path
//        for (int i = in.length-1; i >= 0;  i--){
//            r2ldelay += in[in.length-1] - in [i];            
//        }
//        
//        for (int i = 0; i < in.length; i++){
//            /*
//            try cur point to right end + right to left straight path
//            THEN vice versa..
//            */
//            int curright = 0;
//            int curleft = 0;
//            for (int j = i+1; j < in.length; j++){
//                curright += in[j]-in[j-1];
//            }
//            curright += r2ldelay;
//            
//            for (int j = i-1; j >= 0; j--){
//                curleft += in[j+1]-in[j];
//            }
//            curleft += l2rdelay;
//            min = Math.min(min,curright);
//        min = Math.min(min,curleft);
//        }
//        return min;
//    }
//    
//    public static void main(String args[]){
//        DP dp = new DP();
//        int a[] = {0,9,10,11,20};
//        System.out.println(dp.getMinDelay(a));
//    }
//}
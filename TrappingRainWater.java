public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0, i = 0, j=A.length-1,lmax=-1,rmax=-1;
        while(i<j){
            lmax = Math.max(lmax,A[i]);
            rmax = Math.max(rmax,A[j]);
            if(lmax <= rmax)
                area += (A[++i]<lmax)?(lmax-A[i]):0;
            else
                area += (A[--j]<rmax)?(rmax-A[j]):0;
            
        }
        return area;
    }
}

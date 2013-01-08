package problems;
//TODO update it fixing the bug. Use Saket code.
public class MissingPositive {
	public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        for (int i = 0; i < A.length; i++){
            if ((A[i] > A.length) || (A[i]<=0)){
                continue;            
            }else{
            	if (A[i]-1 == i) continue;
            	int c = A[i];
                if ((A[c-1] < A.length) && (A[c-1]>0)){
                    A[A[c-1]] = A[c-1];
                }
                A[c-1] = c;
            }           
        }
        int i = 1;
        for (Integer a : A){
            if (a!=i) return i;
            else i++;
        }
        return A.length+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
MissingPositive mp = new MissingPositive();
System.out.println(mp.firstMissingPositive(new int[]{3,4,-1,1}));
	}

}

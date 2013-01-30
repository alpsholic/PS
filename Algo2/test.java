package Algo2;

import java.util.Arrays;

public class test {

	public static void sort(int a[]){
		Arrays.sort(a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = {3,5,1,2,6};
		sort(b);
		for(int i = 0; i <5;i++)
			System.out.print(b[i]+" ");
		int[][] a = new int[3][4];
		System.out.println(" a.length " + a[0].length);

	}

}

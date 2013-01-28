package Algo2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class PS5Q1TPSOld {
	public static class Entry{
		BitSet S; //represents the set {1,5,6} will have those bits set 
		int j;
		double val; //this contains the value for A[S,j]
		
		public Entry(BitSet s, int j, double val) {
			super();
			S = s;
			this.j = j;
			this.val = val;
		}
		
		public Entry(BitSet s, int j) {
			super();
			S = s;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((S == null) ? 0 : S.hashCode());
			result = prime * result + j;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (S == null) {
				if (other.S != null)
					return false;
			} else if (!S.equals(other.S))
				return false;
			if (j != other.j)
				return false;
			return true;
		}		
	}
	
	public static double getVal(int S, int j){
		//NOTE A[S,1] 
		if (j==1) return Double.MAX_VALUE;
		else return (double) 0; //FIXIT
	}
	static int n;
	static double [][] graph;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream(".//Algo2//tsp.txt");
			DataInputStream d = new DataInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(d));
			String str;
			n = Integer.parseInt(br.readLine());
			graph = new double[n][n];
			ArrayList<Float> X = new ArrayList<Float>();
			ArrayList<Float> Y = new ArrayList<Float>();
			//indexes will store a subset and its index into the matrix A;
			HashMap<ArrayList<Integer>,Integer> indexes = new HashMap<ArrayList<Integer>, Integer>();
			ArrayList<Entry> entries = new ArrayList<PS5Q1TPSOld.Entry>();			
			
			while((str=br.readLine())!= null){
				X.add(Float.parseFloat(str.split(" ")[0]));
				Y.add(Float.parseFloat(str.split(" ")[1]));
			}
			for(int i = 0; i<n;i++){
				for(int j =0;j<n;j++){
					if (i == j) graph[i][j] = 0;
					else{
						graph[i][j] = graph[j][i] = Math.sqrt(Math.pow(X.get(i)-X.get(j),2)+Math.pow(Y.get(i)-Y.get(j),2));
					}
				}
			}
			
			//m- size of subsets of {0..n-1}
			BitSet s = new BitSet(n);
			s.flip(0);
			entries.add(new Entry(s,0,0));//[{0},0] = 0
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

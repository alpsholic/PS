package Algo2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Question 1
In this programming problem and the next you'll code up the clustering algorithm from lecture for computing a max-spacing k-clustering. Download the text file here. This file describes a distance function (equivalently, a complete graph with edge costs). It has the following format:
[number_of_nodes]
[edge 1 node 1] [edge 1 node 2] [edge 1 cost]
[edge 2 node 1] [edge 2 node 2] [edge 2 cost]
...
There is one edge (i,j) for each choice of 1≤i<j≤n, where n is the number of nodes. For example, the third line of the file is "1 3 5250", indicating that the distance between nodes 1 and 3 (equivalently, the cost of the edge (1,3)) is 5250. You can assume that distances are positive, but you should NOT assume that they are distinct.

Your task in this problem is to run the clustering algorithm from lecture on this data set, where the target number k of clusters is set to 4. What is the maximum spacing of a 4-clustering?

ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases. And then post them to the discussion forum!
 */
public class PS2Q1 {
	static int[] parents;
	static class Edge implements Comparable<Edge>{
		int i;
		int j;
		int cost;
		public Edge(int i, int j, int cost){
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge arg0) {
			// TODO check the order
			final int BEFORE = 1;
			final int AFTER = -1;
			if (this.cost >= arg0.cost) return BEFORE;
			else return AFTER;
			//return 0;
		}
	}
	public static int numClusters(int[] p){
		//num of distinct parents is the numClusters
		int c = 0;
		int[]p1 = new int[p.length];
		for(int i = 0; i < p.length; i++)
			p1[i] = -1;
		for(int i = 0; i < p.length; i++)
			p1[p[i]] = 1;
		for(int i = 0; i < p.length; i++)
			if (p[i]==1) c++;
		return c;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<ArrayList<Integer>> clusters = new ArrayList<ArrayList<Integer>>();
		int k = 3;
		int n = 0;
		try {
			FileInputStream f = new FileInputStream(".//Algo2//clustering1.txt");
			DataInputStream d = new DataInputStream(f);
			BufferedReader b =  new BufferedReader(new InputStreamReader(d));
			n = Integer.parseInt(b.readLine());
			parents = new int[n];			

			for(int i = 0; i < n;i++){
				parents[i] = i;				
			}
			String str; int i,j,v;
			while((str=b.readLine())!=null){
				i = Integer.parseInt(str.split(" ")[0]);
				j = Integer.parseInt(str.split(" ")[1]);
				v = Integer.parseInt(str.split(" ")[2]);
				edges.add(new Edge(i-1,j-1,v));
			}
			Collections.sort(edges);
			for(Edge e : edges){				
				//merge smaller cluster into bigger one if parents are different- if same, do nothing
				int c1 = parents[e.i];
				int c2 = parents[e.j];
				if ( c1 == c2 ){
					continue;
				}else{
					merge(e.i,e.j);
				}
				if (numClusters(parents)==k) break;
				
			}
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

		//create n clusters
		for(int i = 0; i <n;i++)
			clusters.add(new ArrayList<Integer>(i));
		while(clusters.size() > k){


		}
	}
}
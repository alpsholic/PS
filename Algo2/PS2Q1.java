package Algo2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> clusters = new ArrayList<ArrayList<Integer>>();
		int[][] graph;
		int k = 3;
		int n = 0;
		try {
			FileInputStream f = new FileInputStream(".//Algo2//clustering1.txt");
			DataInputStream d = new DataInputStream(f);
			BufferedReader b =  new BufferedReader(new InputStreamReader(d));
			n = Integer.parseInt(b.readLine());
			graph = new int[n][n];

			for(int i = 0; i < n;i++)
				for(int j = 0; j < n; j++)
					graph[i][j] = Integer.MAX_VALUE;
			String str; int i,j,v;
			while((str=b.readLine())!=null){
				i = Integer.parseInt(str.split(" ")[0]);
				j = Integer.parseInt(str.split(" ")[1]);
				v = Integer.parseInt(str.split(" ")[2]);
				graph[i][j] = v;
				graph[j][i] = v;

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
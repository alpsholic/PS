package Algo2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Question 1
In this programming problem and the next you'll code up the greedy algorithms from lecture for minimizing the weighted sum of completion times.. Download the text file here. This file describes a set of jobs with positive and integral weights and lengths. It has the format
[number_of_jobs]
[job_1_weight] [job_1_length]
[job_2_weight] [job_2_length]
...
For example, the third line of the file is "74 59", indicating that the second job has weight 74 and length 59. You should NOT assume that edge weights or lengths are distinct.

Your task in this problem is to run the greedy algorithm that schedules jobs in decreasing order of the difference (weight - length). Recall from lecture that this algorithm is not always optimal. IMPORTANT: if two jobs have equal difference (weight - length), you should schedule the job with higher weight first. Beware: if you break ties in a different way, you are likely to get the wrong answer. You should report the sum of weighted completion times of the resulting schedule --- a positive integer --- in the box below.

ADVICE: If you get the wrong answer, try out some small test cases to debug your algorithm (and post your test cases to the discussion forum)
 */

public class PS1Q1 {
	static class Job implements Comparable<Job>{
		int weight;
		int length;
		public int val(){
			return weight-length;
		}
		public Job(int w, int l){
			weight = w; length = l;
		}
		@Override
		public int compareTo(Job arg0) {
			final int BEFORE = 1;
			final int EQUAL = 0;
			final int AFTER = -1;
			// TODO Auto-generated method stub
			if (this.val()==arg0.val()){
				return(this.weight>arg0.weight?(BEFORE):(AFTER));
			}
			return(this.val()>arg0.val()?(BEFORE):(AFTER));			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			ArrayList<Job> l = new ArrayList<Job>();
			FileInputStream fstream = new FileInputStream(".\\Algo2\\jobs1.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			str=br.readLine();

			int numJobs = Integer.parseInt(str);
			while ((str=br.readLine())!= null){
				String s[] = str.split(" ");
				l.add(new PS1Q1.Job(Integer.parseInt(s[0]),Integer.parseInt(s[1])));		  
			}
			Collections.sort(l);
			Collections.reverse(l);
			int time = 0;
			double weight = 0;
			for(Job j : l){
				weight += j.weight*(time+j.length);
				time += j.length;				
			}
			System.out.println("the final weighth = "+weight);

		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

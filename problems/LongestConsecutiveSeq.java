package problems;

import java.util.HashMap;

/*
 * Longest Consecutive SequenceFeb 14
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] input = {100, 4, 200, 1, 3, 2};
		int[] input = {1,2,0,1};
		HashMap<Integer, Integer> lengths = new HashMap<Integer, Integer>();
		int max = 1;

		for(int i : input){
			if (lengths.containsKey(i)) continue;
			if (lengths.containsKey(i-1)&&lengths.containsKey(i+1)){

				lengths.put(i, lengths.get(i-1) + lengths.get(i+1)+ 1);
			}
			else if (lengths.containsKey(i-1)){
				lengths.put(i, lengths.get(i-1) + 1);				
			}else if (lengths.containsKey(i+1)){
				lengths.put(i, lengths.get(i+1) + 1);				
			}

			if (!lengths.containsKey(i))
				lengths.put(i, 1);
		}

		for(int i : input){

			if (lengths.containsKey(i-1)){
				lengths.put(i, lengths.get(i-1) + 1);				
			}else if (lengths.containsKey(i+1)){
				lengths.put(i, lengths.get(i+1) + 1);				
			}				

		}



		for(int i : lengths.values()){
			if (max < i)
				max = i;
		}

		System.out.println("length " + max);
	}

}

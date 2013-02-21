package problems;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Longest Consecutive SequenceFeb 14
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSeq {

	public static void old(){
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {100, 4, 200, 1, 3, 2};
		//int[] input = {1,2,0,1};
		//key == start, value = end of each seq seen so far (to find end of a seq starting at i)
		HashMap<Integer, Integer> starting = new HashMap<Integer, Integer>();
		//key=end, value = start (to find start of a seq ending at i)
		HashMap<Integer, Integer> ending = new HashMap<Integer, Integer>();

		for(int i : input){
			//check if there is a seq starting with i+1 and another one ending at i-1
			if (starting.containsKey(i+1) && ending.containsKey(i-1)){
				//i merges both seqs
				int s = ending.get(i-1);//start point of seq ending at i-1
				int e = starting.get(i+1);//end point of seq starting at i+1
				starting.put(s, e);
				ending.put(e, s);				
			}else if (starting.containsKey(i+1)){
				int e = starting.get(i+1);
				starting.put(i, e);
				ending.put(e, i);
			}else if (ending.containsKey(i-1)){
				int s = ending.get(i-1);
				ending.put(i, s);
				starting.put(s, i);
			}else {
				starting.put(i, i);
				ending.put(i, i);
			}
		}
		int max = 1;
		for (Entry<Integer, Integer> e : starting.entrySet()){
			int i = e.getValue()-e.getKey()+1;
			if (max < i){
				max = i;				
			}			
		}
		System.out.println("max : " + max);
	}

}

package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maintain median of an input stream: maintain of the part of the input stream seen so far (upto i th element).
 * Can be done with two heaps: Median is max of all prev elements (less than itself) and min of 
 * all next elements (greater than itself). Maintain one min heap and one max heap- no. of 
 * elements in each should be i/2. If it crosses it, extract min (max) and insert into max-(min-)heap.
 * @author rammohan
 *
 */
public class MedianMaintenance {
	
	double median;
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	
	public MedianMaintenance(){
		
		maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				if (x >= y) return 1;
				return -1;
			}
		});
		minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				if (x <= y) return 1;
				return -1;
			}
		});		
	}
	public void processNextElement(int i){
		if (maxHeap.size() == 0){
			maxHeap.add(i);
			median = i;
			return;
		}
		if (i < maxHeap.peek()){
			minHeap.add(i);
		}else
			maxHeap.add(i);
		if (maxHeap.size()- minHeap.size() > 1){
			minHeap.add(maxHeap.poll());
		}
		if (minHeap.size() - maxHeap.size() > 1){
			maxHeap.add(minHeap.poll());
		}
		if (maxHeap.size() == minHeap.size()){
			median = (double)(minHeap.peek() + maxHeap.peek())/2;
			return;
		}
		if (maxHeap.size() > minHeap.size()) median = maxHeap.peek();
		else median = minHeap.peek();
	}
	
	public double getCurMedian(){
		return median;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a = {2,-1,5,3,6};
		MedianMaintenance m = new MedianMaintenance();
		for(int i : a){
			m.processNextElement(i);
			System.out.println("median so far " + m.getCurMedian());
		}

	}

}

class CompG implements Comparator<Integer>{
	public int compare(Integer x, Integer y){
		if (x >= y) return 1;
		return -1;
	}
}

class CompL implements Comparator<Integer>{
	public int compare(Integer x, Integer y){
		if (x <= y) return 1;
		return -1;
	}
}


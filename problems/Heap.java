package problems;

import java.util.ArrayList;
//implements min heap
public class Heap {

	ArrayList<Integer> heap;
	public Heap(){
		heap = new ArrayList<Integer>();		
	}
	int getParent(int index){
		if (index%2 == 0){
			return index/2 -1;
		}else return (int)Math.ceil((index-1)/2);
	}

	int getLChild(int index){
		return 2*index+1;
	}

	int getRChild(int index){
		return 2*(index+1);
	}
	public void insert(int i){
		heap.add(i);
		if (heap.size()==1) return;
		//bottom up or bubble up
		//swap with parents until a min parent is met
		int index = heap.size()-1;
		while(heap.get(getParent(index)) > i){
			//swap with parent node
			int temp = heap.get(index);
			heap.add(index, heap.get(getParent(index)));
			heap.add(getParent(index),temp);
			index = getParent(index);
		}
	}

	public int extractMin(){
		//bubble-down
		//swap the min with the last element and then start pushing it down until heap property satisfied
		int ret = heap.get(0);
		heap.add(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int index = 0;
		boolean done = true;
		while(done){
			if (getLChild(index) >= heap.size()){
				break;
			}
			if (heap.get(index) <= heap.get(getLChild(index)))
					{
				if (getRChild(index)<heap.size() && (heap.get(index) <= heap.get(getRChild(index))))
				break;				
			}else{
				int swap;
				//get min of children
				if (heap.get(getLChild(index)) < heap.get(getRChild(index))){
					swap = getLChild(index);
				}else{
					swap = getRChild(index);
				}
				int temp = heap.get(index);
				heap.add(index,heap.get(swap));
				heap.add(swap,temp);
				index = swap;
			}
		}

		return ret;
	}

	public void delete(int i){

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []n ={-2,6,3,2,10,12,1};
		Heap h = new Heap();
		for(int i : n){
			h.insert(i);
		}
		for(int i = 0; i < n.length; i++)
			System.out.print(h.extractMin()+" ");
	}
}
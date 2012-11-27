package problems;

import java.util.Stack;

/*
 * How would you design a stack which, in addition to push and pop, also has a function 
min which returns the minimum element? Push, pop and min should all operate in 
O(1) time 
 */

public class MyMinStack extends Stack{
	
	public void push(int data){		
		if (this.isEmpty()) 
		{
			super.push(new MyMinStackNode(data,data));
			return;
		}
		MyMinStackNode t1 =(MyMinStackNode)this.peek();
		MyMinStackNode t = new MyMinStackNode(data, Math.min(data,t1.getMin()));
		super.push(t);
	}
	
	public int getMin(){
		if (this.peek() == null) return Integer.MAX_VALUE;
		MyMinStackNode t =(MyMinStackNode)this.peek(); 
		return t.getMin();
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMinStack s = new MyMinStack();
		s.push(2);
		s.push(1);
		System.out.println("curmin:: " + s.getMin());
		s.pop();
		System.out.println("curmin:: " + s.getMin());
	}

}

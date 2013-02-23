package problems;
/*
 * we have given a char array like “a1b2c3″ we have to convert this array to array like 
 * this “abbccc” .This has to be done in place as we have given that array has 
 * just enough space to hold the expanded array.

example:

1)input: a1b1c1

output:abc
 */

public class StringManipulation {
	int max =0;
	
	public void solve(char[] in, int index, int freeLoc){
		//fill in[index] char from in[freeLoc] to in[newFreeLoc-1]
		if (index > in.length-1) return;
		if (in[index]==' ') return;
		
		int newFreeLoc = in[index+1]+freeLoc;
		max = Math.max(max, newFreeLoc);
		char ch = in[index];
		
		solve(in,index+2,newFreeLoc);
		for(int i = freeLoc; i < newFreeLoc;i++)
			in[i] = ch;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringManipulation m = new StringManipulation();
		//char[] in = {'a',1,'b',2,'c',3};
		char[] in = {'a',1,'b',1,'c',1};
		
		m.solve(in, 0, 0);
		for(int i = m.max; i < in.length; i++)
			in[i] = ' ';
		String str = new String(in);
		System.out.println("out " + str);

	}

}

package Algo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TwoSAT {
	int n;
	ArrayList<Clause> clauses;
	//final value: clause1 AND clause2 ...
ArrayList<Boolean> configuration;
	//boolean [] configuration;
	ArrayList<Clause> falseClauses;

	public TwoSAT(int n){
		this.n = n;
		clauses = new ArrayList<Clause>();
		configuration = new ArrayList<Boolean>();
		for (int i = 0; i < n; i++)
			configuration.add(true);
		falseClauses= new ArrayList<Clause>();
	}
	
	public Clause getRandomFalse(){
		//fill falses
		falseClauses.clear();
		for (Clause c : clauses){
			if (!c.evaluate(configuration.get(Math.abs(c.i)), configuration.get(Math.abs(c.j))))
				falseClauses.add(c);
		}
		if (falseClauses.size() == 0)
			return null;
		Collections.shuffle(falseClauses);
		return falseClauses.get(0);		
	}

	//implements Padimitriou's algo
	public void run2SAT(){
		int count = 1;
		boolean done = false;
		System.out.println("n="+n);
//		System.out.println(Math.log(n)/Math.log(2));
		System.out.println("2*n*n "+(double)2*n*n);
		while (count <= Math.log(n)/Math.log(2)){
			int count2 = 1;
			//random assingment
			Collections.shuffle(configuration);			
			while (count2 <= (double)2*n*n){
				Clause c = getRandomFalse();
				if (c==null) {
					done = true;
					break;
				}
				//shuffle literals
				int r = new Random().nextInt(2)+1;
				if (r==1){
					Boolean b = configuration.get(Math.abs(c.i));
					b = !b;
				}else{
					Boolean b = configuration.get(Math.abs(c.j));
					b = !b;					
				}			
				count2++;
			}
			System.out.println("count2 "+count2);
			if (done) break;
			count++;
		}
		System.out.println("count "+count);
		if (done) System.out.println("satisfiable");
		else System.out.println("not satisfiable");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoSAT sat;
		int count = 1;
		try {
			while (count <=2 ){
				String fileName = "2sat"+count+".txt";
				System.out.println(fileName);
				BufferedReader br = new BufferedReader(new FileReader(".//Algo2//"+fileName));
				sat = new TwoSAT(Integer.parseInt(br.readLine()));
				String str;
				while((str = br.readLine())!=null){
					int i = Integer.parseInt(str.split(" ")[0]);
					if (i<0) i = i+1;
					else i = i-1;
					int j = Integer.parseInt(str.split(" ")[1]);
					if (j<0) j=j+1;
					else j=j-1;
					sat.clauses.add(new Clause(i,j));
				}

				sat.run2SAT();
				br.close();
				count++;
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

	}

}

class Clause{
	int i;
	int j;

	public Clause(int a, int b){
		i = a;
		j = b;
	}
	public boolean evaluate(boolean i1, boolean j1){
		if (i<0) i1 = !i1;
		if (j<0) j1 = !j1;

		return i1||j1;
	}
}
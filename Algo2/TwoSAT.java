package Algo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TwoSAT {
	
	ArrayList<Clause> clauses;
	//final value: clause1 AND clause2 ...
	boolean [] configuration;
	ArrayList<Integer> falseClauses;
	
	public TwoSAT(int n){
		clauses = new ArrayList<Clause>();
		configuration = new boolean[n];
		falseClauses= new ArrayList<Integer>();
	}
	
	//implements Padimitriou's algo
	public void run2SAT(){
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new FileReader(".//Algo2//"));

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
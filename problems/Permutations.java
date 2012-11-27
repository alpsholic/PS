package problems;

public class Permutations {

	public void allPerms(int a[], int loc){
	
		if (loc == a.length-1) {for (int i = 0; i < a.length; i++) System.out.print(a[i]);System.out.println();}
		else for (int j = loc; j < a.length; j++){
			//swap a[loc] and a[j]
			int tmp = a[loc]; a[loc]=a[j];a[j]=tmp;
			allPerms(a,loc+1);
			tmp = a[loc]; a[loc]=a[j];a[j]=tmp;			
		} 
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		Permutations p = new Permutations();
		p.allPerms(a, 0);
	}

}

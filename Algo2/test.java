package Algo2;

interface Ione{
	int a = 0;
	public void test();
	public void one();
}

interface Itwo{
	int a = 1;
	public void test();
	public void two();
}

interface Ithree{
	public void test();
	public void three();
}


public class Test implements Ione,Itwo,Ithree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		int[] b = {3,5,1,2,6};
		sort(b);
		for(int i = 0; i <5;i++)
			System.out.print(b[i]+" ");
		int[][] a = new int[3][4];
		System.out.println(" a.length " + a[0].length);
=======
		Test t = new Test();
		Ione i1 = (Ione)t;
		i1.two();
	System.out.println(Ione.a);;
		t.test();
		i1.test();
		i1.one();

	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("in test" + Ione.a);
		
	}

	@Override
	public void three() {
		// TODO Auto-generated method stub
		System.out.println("three");
	}
>>>>>>> 19e9ed19f828c7d3ab7b9e1df1730a6971244d4f

	@Override
	public void two() {
		// TODO Auto-generated method stub
		System.out.println("two");
		
	}

	@Override
	public void one() {
		// TODO Auto-generated method stub
		System.out.println("one");
		
	}

}

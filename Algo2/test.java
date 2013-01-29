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

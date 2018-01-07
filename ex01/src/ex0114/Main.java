package ex0114;

public class Main {

	public static void main(String[] args) {

		int N = 13;
		System.out.println(dynamicFibo(N));
		System.out.println(simpleFibo(N));
	}
	
	private static int dynamicFibo(int n) {
		int[] fiboList = new int[n];
		fiboList[0] = fiboList[1] = 1;
		
		for (int i = 2; i < fiboList.length; i++) {
			fiboList[i] = fiboList[i-1] + fiboList[i-2];
		}
		return fiboList[n-1]; 
	}
	
	private static int simpleFibo(int n) {
		int first = 1;
		int second = 1;
		int third = 0;
		
		for(int i=2;i<n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		
		return third;
	}

}

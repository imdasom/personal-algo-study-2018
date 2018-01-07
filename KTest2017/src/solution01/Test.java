package solution01;

public class Test {
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {	
			int intResult = arr1[i] | arr2[i];
			String result = Integer.toBinaryString(intResult);
			answer[i] = result.replace("0", " ").replace("1", "#");
			int zeroNum = (n-1) - ((int)(Math.log(intResult) / Math.log(2)));
			for (int j = 0; j < zeroNum; j++) {
				answer[i] = " " + answer[i];
			}
		}
	}
}

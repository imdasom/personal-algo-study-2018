package sampletest;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SampleTest01 {
	enum ORDER {
		ASC, DESC
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sc.close();

		String[] arr = new String[10];
		int index = 0;
		
		while(st.hasMoreTokens()) {
			arr[index++] = st.nextToken();
		}
		
		System.out.println(getSumByOrder(ORDER.ASC, arr, index) + getSumByOrder(ORDER.DESC, arr, index));
	}

	private static int getSumByOrder(ORDER order, String[] arr, int size) {
		for (int i = 0; i < size - 1; i++) {
			
			int minmaxIndex = i;
			for (int j = i + 1; j < size; j++) {
				String targetNum = convertNumberLength(arr[j]);
				String minmaxNum = convertNumberLength(arr[minmaxIndex]);
				if (compare(order, targetNum, minmaxNum)) {
					minmaxIndex = j;
				}
			}
			
			String temp = arr[minmaxIndex];
			arr[minmaxIndex] = arr[i];
			arr[i] = temp;
		}
		
		String result = "";
		for (int i = 0; i < size; i++) {
			result += arr[i];
		}
		return Integer.parseInt(result);
	}

	private static String convertNumberLength(String number) {
		return (number.length() == 1) ? (number + number) : number;
	}

	private static boolean compare(ORDER order, String targetNum, String minmaxNum) {
		int num1 = (int) targetNum.charAt(0) - (int) minmaxNum.charAt(0);
		int num2 = (int) targetNum.charAt(1) - (int) minmaxNum.charAt(1);
		
		switch (order) {
		case ASC:
			return (num1 < 0) ? (true) : ((num1 == 0 && num2 < 0) ? (true) : (false));
		case DESC:
			return (num1 > 0) ? (true) : ((num1 == 0 && num2 > 0) ? (true) : (false));
		default:
			return false;
		}
	}

}

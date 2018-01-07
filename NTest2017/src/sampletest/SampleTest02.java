package sampletest;

import java.util.Scanner;

public class SampleTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				arr[col][row] = sc.nextInt();
			}
		}
		sc.close();

		for (int row = 0; row < N; row++) {
			if(row!=0) {
				System.out.println();
			}
			for (int col = 0; col < N; col++) {
				System.out.print(((col!=0) ? (" ") : ("")) + arr[row][col]);
			}
		}
	}
}

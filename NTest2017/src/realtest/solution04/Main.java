package realtest.solution04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int startI = 0, startJ = 0;
	static int[][] arr;
	static int numOfSpace = 0;
	static int[] spaceList;
	static int spaceIndex = 0;
	static int space = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		spaceList = new int[N];
		arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (findFirstPoint()) {
			DFS(startI, startJ);
			numOfSpace++;
			spaceList[spaceIndex++] = space;
			space = 0;
		}

		for (int i = 0; i < numOfSpace; i++) {
			int minIndex = i;
			for (int j = 1; j < args.length; j++) {
				if (spaceList[j] < spaceList[minIndex]) {
					minIndex = j;
				}
			}
			int temp = spaceList[i];
			spaceList[i] = spaceList[minIndex];
			spaceList[minIndex] = temp;
		}

		System.out.println(numOfSpace);
		if(numOfSpace > 0) {
			String result = "";
			for (int i = 0; i < numOfSpace; i++) {
				result += (i != 0) ? " " : "";
				result += spaceList[i];
			}
			System.out.println(result);
		}
	}

	public static void DFS(int i, int j) {
		arr[i][j] = 0;
		space++;

		if (i - 1 >= 0 && arr[i - 1][j] == 1) {
			DFS(i - 1, j);
		}
		if (i + 1 < N && arr[i + 1][j] == 1) {
			DFS(i + 1, j);
		}
		if (j - 1 >= 0 && arr[i][j - 1] == 1) {
			DFS(i, j - 1);
		}
		if (j + 1 < N && arr[i][j + 1] == 1) {
			DFS(i, j + 1);
		}
	}

	public static boolean findFirstPoint() {
		for (int i = startI; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					startI = i;
					startJ = j;
					return true;
				}
			}
		}
		return false;
	}

}

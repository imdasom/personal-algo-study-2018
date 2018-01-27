package net.acmicpc.problem2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] stairs;
	private static int[] cache;
	private static int maxPoint = 0;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader(new File("src\\net\\acmicpc\\problem2579\\input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfStairs = Integer.parseInt(br.readLine());
		stairs = new int[numOfStairs];
		cache = new int[numOfStairs];
		for (int i = 0; i < numOfStairs; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		cache[0] = stairs[0];
		cache[1] = stairs[0] + stairs[1];
		cache[2] = getMax(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		for (int i = 3; i < stairs.length; i++) {
			cache[i] = getMax(cache[i-2] + stairs[i], cache[i-3] + stairs[i - 1] + stairs[i]);
		}
		System.out.println(cache[numOfStairs - 1]);
	}

	public static int getMax(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}

}

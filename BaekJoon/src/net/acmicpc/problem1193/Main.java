package net.acmicpc.problem1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int level = 0;
		int total = 0;
		while (total < num) {
			total += (++level);
		}

		int target = total - num;
		int result1 = 1 + target;
		int result2 = level - target;

		if(level % 2 == 0) {
			//Â¦¼öÀÏ¶§
			System.out.println(result2 + "/" + result1);;
		} else {
			System.out.println(result1 + "/" + result2);
		}
	}

}

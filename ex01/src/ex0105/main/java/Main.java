package ex0105.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static int num;
	private static int[] tree;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./src/ex0105/input/input.txt")));
		
		num = sc.nextInt();
		tree = new int[num];
		for(int i=0; i<num; i++) {
			tree[i] = sc.nextInt();
		}
		
		int target = sc.nextInt();
		int location = func(target, 0) + 1;
		System.out.println("RESULT :: " + location);
		sc.close();
	}
	
	public static int func(int target, int index) {
		if(tree[index] == target) {
			return index;
		} else {
			return (tree[index] > target) ? func(target, index*2) : func(target, index*2+1);
		}
	}

}

package ex0110.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./src/ex0110/input/input.txt")));
		int numOfCoin = sc.nextInt();
		int[] coinType = new int[numOfCoin];
		for (int i = 0; i < coinType.length; i++) {
			coinType[i] = sc.nextInt();
		}		
		int price = sc.nextInt();
		int payment = sc.nextInt();
		sc.close();
		
		int change = payment - price;
		for(int coin : coinType) {
			System.out.print((change / coin) + " ");
			change = change % coin;
		}
	}

}

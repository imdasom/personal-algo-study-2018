package ex0108.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("./src/ex0108/input/input.txt")));
		String key = br.readLine();
		String message = br.readLine();
		br.close();
		
		for (int i = 0; i < key.length(); i++) {
			char crypto = (char) (key.charAt(i) ^ message.charAt(i));
			System.out.print(crypto);
		}
		System.out.println();
		
	}

}

package ex0107.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./resource/input.txt")));
		LinkedList linkedList = new LinkedList();
		
		int count = sc.nextInt();
		for(int i=0; i<count; i++) {
			linkedList.insertLastNode(sc.nextInt());
		}
		
		int data = sc.nextInt();
		int index = sc.nextInt();
		linkedList.insertMiddleNode(index, data);
		
		linkedList.printList();
		
		sc.close();
	}

}

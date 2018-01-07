package ex0106.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("./src/ex0106/input/input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BinaryTree binaryTree = new BinaryTree();
		while(st.hasMoreTokens()) {
			String parent = st.nextToken();
			String child = st.nextToken();
			binaryTree.insertMiddleNode(parent, child);
		}
		
		binaryTree.printPreOrder();
	}

}

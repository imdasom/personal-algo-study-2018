package ex0109.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./src/ex0109/input/input.txt")));
		
		int numOfNode = sc.nextInt();
		int startNum = sc.nextInt();
		Node[] nodes = new Node[numOfNode + 1];
		for (int i = 1; i <= numOfNode; i++) {
			nodes[i] = new Node();
		}
		
		int target = sc.nextInt();
		int adj = sc.nextInt();
		while(target!=(-1) && adj!=(-1)) {
			nodes[target].adjNode.add(adj);
			nodes[adj].adjNode.add(target);
			target = sc.nextInt();
			adj = sc.nextInt();
		}
		sc.close();
		
		searchDepthFirst(nodes, startNum);
	}
	
	public static void searchDepthFirst(Node[] nodes, int startIndex) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(startIndex);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			Node node = nodes[cur];
			node.isVisited = true;
			
			for(int n : node.adjNode) {
				if(!nodes[n].isVisited) {
					stack.push(cur);
					stack.push(n);
					System.out.println(cur + " " + n);
					break;
				}
			}
		}
	}
}

class Node {
	public boolean isVisited = false;
	public ArrayList<Integer> adjNode = new ArrayList<Integer>();
}
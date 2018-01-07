package ex0111.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public final static int NUM_OF_NODE = 5;
	public static List<Node>[] adjNodeList;
	public static DijkstraNode[] dijkNodeList;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./src/ex0111/input/input.txt")));
		
		int source = sc.nextInt();
		int destination = sc.nextInt();
		adjNodeList = new ArrayList[NUM_OF_NODE];
		dijkNodeList = new DijkstraNode[NUM_OF_NODE];
		for (int i = 0; i < NUM_OF_NODE; i++) {
			adjNodeList[i] = new ArrayList<Node>();
			dijkNodeList[i] = new DijkstraNode();
			
			for (int j = 0; j < NUM_OF_NODE; j++) {
				int dis = sc.nextInt();
				if(dis > 0) {
					adjNodeList[i].add(new Node(j, dis));
				}
			}
		}
		sc.close();
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(new Node(source, 0));
		dijkNodeList[source].dis = 0;
		 
		while(!q.isEmpty()) {
			int curIndex = q.poll().index;
			DijkstraNode curNode = dijkNodeList[curIndex];
			if(!curNode.isVisited) {
				curNode.isVisited = true;
				
				List<Node> adjList = adjNodeList[curIndex];
				if(!adjList.isEmpty()) {
					for(Node adjNode : adjList) {
						int adjIndex = adjNode.index;
						DijkstraNode dijkNode = dijkNodeList[adjIndex];
						if(!dijkNode.isVisited) {
							int newDis = curNode.dis + adjNode.dis;
							dijkNode.dis = (newDis < dijkNode.dis) ? newDis : dijkNode.dis;
							q.offer(new Node(adjIndex, dijkNode.dis));
						}
					}
				}
			}
		}
		System.out.println(dijkNodeList[destination].dis);
	}
	
}

class Node implements Comparable<Node> {
	public int index;
	public int dis;
	
	public Node(int index, int dis) {
		this.index = index;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node n) {
		return this.dis - n.dis;
	}
}

class DijkstraNode {
	public boolean isVisited = false;
	public int dis = 999;
}
package ex0112.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("./src/ex0112/input/input.txt")));
		int intervalClient = sc.nextInt();
		int perServiceTime = sc.nextInt();
		int totalTime = sc.nextInt();
		sc.close();
		
		Queue<Integer> q = new LinkedList<Integer>();
		int clientNo = 0;
		int serviceTime = perServiceTime;
		int maxClientCount = 0;
		int totalClientCount = 0;
		for(int i=1; i<=totalTime; i++) {
			if(clientNo > 0) {
				serviceTime++;
				if(q.size() > maxClientCount) {
					maxClientCount = q.size();
				}
			}
			
			if(i % intervalClient == 0) {
				q.offer(++totalClientCount);
			}
			
			if(serviceTime == perServiceTime) {
				clientNo = 0;
				if(!q.isEmpty()) {
					clientNo = q.poll();
					serviceTime = 0;
				}
			}
		}
		
		System.out.println(totalClientCount + " " + q.size() + " " + maxClientCount);
	}
}

package com.algospot.picnic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] coupleList;
	private static boolean[] coupleListCheck;
	private static boolean[] personList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\com\\algospot\\picnic\\input.txt")));
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int personNum = Integer.parseInt(st.nextToken());
			int coupleNum = Integer.parseInt(st.nextToken());
			coupleList = new boolean[personNum][personNum];
			coupleListCheck = new boolean[coupleNum];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < coupleNum; j += 2) {
//				coupleList[j] = st.nextToken() + " " + st.nextToken();
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				coupleList[num1][num2] = coupleList[num2][num1] = true;
			}
			
			personList = new boolean[personNum];
			System.out.println(matchCouple(0));
		}
		
		br.close();
	}
	
	private static int matchCouple(int matchCount) {
		if(isAllMatched(personList)) {
			return ++matchCount;
		}
		
		int personNum = personList.length;
		int person1 = 0;
		for (person1 = 0; person1 < personNum; person1++) {
			if(!personList[person1]) break;
		}

		for (int person2 = person1 + 1; person2 < personNum; person2++) {
			if(!personList[person2] && coupleList[person1][person2]) {
				personList[person1] = personList[person2] = true;
				matchCount = matchCouple(matchCount);
				personList[person1] = personList[person2] = false;
			}
		}
		
		return matchCount;
	}
	
	private static boolean isAllMatched(boolean[] personList) {
		for(boolean coupledFlag : personList) {
			if(!coupledFlag) {
				return false;
			}
		}
		return true;
	}
}

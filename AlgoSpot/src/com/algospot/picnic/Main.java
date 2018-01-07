package com.algospot.picnic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static String[] coupleList;
	private static boolean[] personList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\com\\algospot\\picnic\\input.txt")));
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int personNum = Integer.parseInt(st.nextToken());
			int coupleNum = Integer.parseInt(st.nextToken());
			coupleList = new String[coupleNum];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < coupleNum; j++) {
				coupleList[j] = st.nextToken() + " " + st.nextToken();
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
		for (int person1 = 0; person1 < personNum; person1++) {
			if(personList[person1]) continue;
			
			for (int person2 = 0; person2 < personNum; person2++) {
				if(person1 != person2) continue;
				if(personList[person2]) continue;
				
				if(canCouple(person1, person2)) {
					personList[person1] = personList[person2] = true;
					matchCount = matchCouple(matchCount);
					personList[person1] = personList[person2] = false;
				}
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
	
	private static boolean canCouple(int person1, int person2) {
		if(person1 > person2) return false;
		
		for(String couple : coupleList) {
			if(couple.contains(person1 + "") && couple.contains(person2 + "")) {
				return true;
			}
		}
		return false;
	}

}

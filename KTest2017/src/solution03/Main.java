package solution03;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
//		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
	}
	
	private static int solution(int cacheSize, String[] dataList) {
		int answer = 0;
		
		Stack<String> cache = new Stack<String>();
		
		for(String data : dataList) {
			if(cache.contains(data)) {
				answer += 1;
				cache.remove(data);
				cache.push(data);
			} else {
				answer += 5;
				if(cache.size() == cacheSize) {
					cache.remove(0);
				}
				cache.push(data);
			}
		}
		
		return answer;
	}

}

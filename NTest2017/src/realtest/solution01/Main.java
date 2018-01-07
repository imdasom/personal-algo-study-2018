package realtest.solution01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] dataList = new Integer[st.countTokens()];
		for (int i = 0; i < dataList.length; i++) {
			dataList[i] = Integer.parseInt(st.nextToken());
		}
		
		final int MAX_NUM = 3;
		Stack<Integer> cache = new Stack<Integer>();
		StringBuilder sb = new StringBuilder("");

		for (Integer data : dataList) {
			if (cache.contains(data)) {
				cache.remove(data);
				cache.push(data);
			} else {
				if (cache.size() == MAX_NUM) {
					sb.append(cache.remove(0) + "\n");
				}
				cache.push(data);
			}
		}
		
		System.out.println(sb.toString().equals("") ? "0" : sb.toString());
	}
}

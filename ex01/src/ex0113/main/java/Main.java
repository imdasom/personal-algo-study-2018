package ex0113.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("./src/ex0113/input/input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int startNum = Integer.parseInt(st.nextToken());
		int endNum = Integer.parseInt(st.nextToken());
		boolean[] removeList = new boolean[(endNum - startNum) + 1];

		int startMultiple = 2;
		int endMultiple = (int) Math.sqrt(endNum);

		for (int mul = startMultiple; mul <= endMultiple; mul++) {
			for (int num = startNum; num <= endNum && mul <= num; num++) {
				if (num % mul == 0) {
					removeList[num - startNum] = true;
				}
			}
		}

		int totalCount = 0;
		for (int i = 1; i < removeList.length; i++) {
			if (!removeList[i]) {
				String str = (i + startNum) + " ";
				if (++totalCount % 10 == 0) {
					str += "\n";
				}
				System.out.print(str);
			}
		}
		System.out.println("\n\n" + totalCount);
	}

}

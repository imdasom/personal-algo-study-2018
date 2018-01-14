package net.acmicpc.problem1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String targetNum = br.readLine();
		int[] setCheck = new int[9];

		for (int i = 0; i < targetNum.length(); i++) {
			char c = targetNum.charAt(i);
			if(c == '6' || c == '9') {
				setCheck[6]++;
			} else {
				setCheck[c-48]++;
			}
		}
		setCheck[6] = (int) Math.ceil(setCheck[6]/2.0);

		int max = 0;
		for (int i = 0; i < setCheck.length; i++) {
			if(max < setCheck[i]) {
				max = setCheck[i];
			}
		}
		System.out.println(max);
		
		//��Ʈ���� ����ϸ� ���� ����� ���� �޸�/�ð��� ������
		//System.out.println(Arrays.stream(setCheck).max().getAsInt()); 
	}
}

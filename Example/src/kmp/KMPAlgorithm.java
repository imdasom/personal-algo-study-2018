package kmp;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
	static List<Integer> location = new ArrayList<Integer>();

	public static void main(String[] args) {
		String text = "ABCDEAABCDABDEABCDE";
		String search = "ABCD";
		int[] pi = getPI(search);
		boolean result = search(text, search, pi);
		System.out.println(result);
		for(Integer i : location) {
			System.out.println(i);
		}
	}

	private static int[] getPI(String s) {
		char[] chars = s.toCharArray();
		int[] pi = new int[s.length()];

		int comparedIndex = 0;
		for (int baseIndex = 1; baseIndex < s.length(); baseIndex++) {

			while (chars[baseIndex] != chars[comparedIndex] && comparedIndex > 0) {
				comparedIndex = pi[comparedIndex - 1];
			}

			if (chars[baseIndex] == chars[comparedIndex]) {
				pi[baseIndex] = ++comparedIndex;
			}
		}

		return pi;
	}

	private static boolean search(String text, String pattern, int[] pi) {
		boolean result = false;
		
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		
		int pIndex = 0;
		for (int tIndex = 0; tIndex < textChars.length; tIndex++) {
			
			while(textChars[tIndex] != patternChars[pIndex] && pIndex > 0) {
				pIndex = pi[pIndex - 1];
			}
			
			if(textChars[tIndex] == patternChars[pIndex]) {
				if(pIndex == pattern.length() - 1) {
					result = true;
					location.add(tIndex - pIndex);
					pIndex = pi[pattern.length() - 1];
				} else {
					pIndex++;
				}
			}
		}
		
		return result;
	}

}

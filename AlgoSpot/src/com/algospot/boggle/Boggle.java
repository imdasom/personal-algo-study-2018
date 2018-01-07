package com.algospot.boggle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boggle {
	
	private static final int BOARD_SIZE = 5;
	private static final int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static final int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		
		char[][] board;
		String[] words;
		
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\com\\algospot\\boggle\\input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			board = getBoard(br);
			words = getWords(br);
			
			for (int j = 0; j < words.length; j++) {
				boolean result = hasWord(board, words[j]);
				System.out.println(words[j] + " " + (result ? "YES" : "NO"));
			}
		}
	}
	
	private static char[][] getBoard(BufferedReader br) throws IOException {
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			String line = br.readLine();
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		return board;
	}
	
	private static String[] getWords(BufferedReader br) throws IOException {
		int numOfWord = Integer.parseInt(br.readLine());
		String[] words = new String[numOfWord];
		for (int i = 0; i < numOfWord; i++) {
			words[i] = br.readLine();
		}
		return words;
	}
	
	private static boolean hasWord(char[][] board, String word) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if(board[i][j] == word.charAt(0)) {
					if(word.length() == 1) {
						return true;
					}
					if(hasWord(board, i, j, word)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean hasWord(char[][] board, int i, int j, String word) {
		if(!isRange(board, i, j)) {
			return false;
		}
		if(board[i][j] != word.charAt(0)) {
			return false;
		}
		if(word.length() == 1) {
			return true;
		}
		for (int direction = 0; direction < di.length; direction++) {
			int nextI = i + di[direction];
			int nextJ = j + dj[direction];
			if(hasWord(board, nextI, nextJ, word.substring(1))) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isRange(char[][] board, int i, int j) {
		return (i < 0 || i >= BOARD_SIZE || j < 0 || j >= BOARD_SIZE) ? false : true;
	}

}

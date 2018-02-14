package com.algospot.boardcover;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	/*
		최초 위치 i=0, j=0
		--재귀시작점
		보드가 모두 덮였으면(보드가 모두 덮였는지 체크하는 카운트개수를 비교하면 된다) {
			경우의수 카운트를 증가시킨다
			return;
		}
		현재 위치가 true 이면 {
			1번모양~4번모양 for loop {
				가능한 공간 true로 체크한다, 보드가 모두 덮였는지 체크하는 카운트를 증가시킨다
				다음위치를 찾는다
				재귀호출(i, j) // 다음위치와 배열을 넘긴다
				true로 체크한거 false로 푼다, 보드가 모두 덮였는지 체크하는 카운트를 감소시킨다
			}
		}
		--재귀끝점
	*/

	private static int[][][] coverTypeList = new int[][][] {
			{ {0, 0}, {1, 0}, {0, 1} },
			{ {0, 0}, {0, 1}, {1, 1} },
			{ {0, 0}, {1, 0}, {1, 1} },
			{ {0, 0}, {1, 0}, {1, -1} }
	};

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader (new File(".\\AlgoSpot\\src\\com\\algospot\\boardcover\\input.txt")));

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());

			int blankNum = 0;
			int[][] board = new int[height][width];
			for (int j = 0; j < height; j++) {
				String line = br.readLine().toString();
				for (int k = 0; k < width; k++) {
					switch (line.charAt(k)) {
						case '#':
							board[j][k] = 1;
							break;
						case '.':
							board[j][k] = 0;
							blankNum++;
							break;
						default:
							throw new RuntimeException();
					}
				}
			}

			if(blankNum % 3 != 0) {
				System.out.println(0);
			} else {
				System.out.println(cover(board));
			}
		}
    }

    private static boolean set(int i, int j, int[][] board, int coverType, int delta) {
    	boolean result = true;
		for (int k = 0; k < 3; k++) {
			int nextI = i + coverTypeList[coverType][k][0];
			int nextJ = j + coverTypeList[coverType][k][1];

			if(nextI < 0 || nextJ < 0 || nextI >= board.length || nextJ >= board[k].length) {
				result = false;
			}

			board[nextI][nextJ] += delta;

			if(board[nextI][nextJ] > 1) {
				result = false;
			}
		}

    	return result;
	}

	private static int cover(int[][] board) {
    	// 아직 채우지 못한 가장 좌상단의 칸을 찾는다
		int i = 0;
		int j = 0;
		for (; i < board.length; i++) {
			for (; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					break;
				}
			}
		}

		if(j == -1) {
			return 1;
		}

		int coverCount = 0;
		for (int coverType = 0; coverType < coverTypeList.length; coverType++) {
			if(set(i, j, board, coverType, 1)) {
				coverCount += cover(board);
			}
			set(i, j, board, coverType, -1);
		}

		return coverCount;
    }

}





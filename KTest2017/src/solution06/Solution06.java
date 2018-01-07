package solution06;

public class Solution06 {
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		
		int answer  = 0;
		
		char NONE_EXP = '#';
		while(true) {
			boolean[][] record = getRecord(board, NONE_EXP);
			board = getNextBoard(board, record, NONE_EXP);
			int count = getRemovePuzzleCount(record);
			if(count == 0) {
				break;
			} else {
				answer += count;
			}
		}
		
	}

	private static int getRemovePuzzleCount(boolean[][] record) {
		int count = 0;
		for (int i = 0; i < record.length; i++) {
			for (int j = 0; j < record[0].length; j++) {
				if(record[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean[][] getRecord(String[] board, char noneExp) {
		int ROW_LEN = board.length;
		int COL_LEN = board[0].length();
		boolean[][] record = new boolean[ROW_LEN][COL_LEN];

		for (int row = 0; row < ROW_LEN - 1; row++) {
			for (int col = 0; col < COL_LEN - 1; col++) {
				if(board[row].charAt(col) == noneExp) {
					continue;
				}
				char me = board[row].charAt(col);
				char nextMe = board[row].charAt(col + 1);
				char below = board[row + 1].charAt(col);
				char nextBelow = board[row + 1].charAt(col + 1);

				if ((me == nextMe) && (below == nextBelow) && (me == below)) {
					record[row][col] = true;
					record[row][col + 1] = true;
					record[row + 1][col] = true;
					record[row + 1][col + 1] = true;
				}
			}
		}
		return record;
	}

	private static String[] getNextBoard(String[] board, boolean[][] record, char noneExp) {
		int m = board.length;
		int n = board[0].length();

		String[] sList = new String[m];
		for (int i = 0; i < sList.length; i++) {
			sList[i] = "";
		}

		for (int col = 0; col < n; col++) {

			int newRow = m - 1;
			for (int row = m - 1; row >= 0; row--) {
				if (!record[row][col]) {
					sList[newRow--] += board[row].charAt(col);
				}
			}

			while (newRow >= 0) {
				sList[newRow--] += noneExp;
			}
		}
		return sList;
	}
}

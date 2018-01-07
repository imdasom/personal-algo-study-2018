package solution02;

public class Solution {
	
	public static void main(String[] args) {
//		String dartResult = "1S#2D*3T*";
//		String dartResult = "1D2S#10S";
		String dartResult = "1D#2S*3S";
		int answer = 0;
		int previousPoint = 0;

		char[] array = dartResult.toCharArray();

		for (int i = 0; i < array.length;) {
			int count = 0;

			char c = array[i++];
			switch (c) {
			case '1':
				count = c - 48;
				if (array[i] == '0') {
					i++;
					count += 9;
				}
				break;
			case '0':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				count = c - 48;
				break;
			}

			int newPoint = 0;
			int nextPreviousPoint = 0;
			newPoint = nextPreviousPoint = getPowNum(count, array[i++]);
			
			if (i < array.length) {
				switch (array[i]) {
				case '*':
					i++;
					newPoint *= 2;
					nextPreviousPoint = newPoint;
					newPoint = newPoint + previousPoint;
					break;
				case '#':
					i++;
					newPoint *= (-1);
					nextPreviousPoint = newPoint;
					break;
				}
			}

			answer += newPoint;
			previousPoint = nextPreviousPoint;
		}
	}

	private static int getPowNum(int count, char pow) {
		switch (pow) {
		case 'S':
			return (int) Math.pow(count, 1);
		case 'D':
			return (int) Math.pow(count, 2);
		case 'T':
			return (int) Math.pow(count, 3);
		}
		return 0;
	}
}

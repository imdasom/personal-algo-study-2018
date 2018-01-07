package realtest.solution02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String encdec = st.nextToken();
		String secretStr = st.nextToken();
		int rotate = Integer.parseInt(st.nextToken());
		char[] message = st.nextToken().toCharArray();

		final int BASE_LEN = message.length;
		char[] encdecMessage = new char[BASE_LEN];
		int startIndex = 0;
		
			while(secretStr.length() < message.length) {
				secretStr += secretStr;
			}
		char[] secret = secretStr.toCharArray();
		

		switch (encdec) {
		case "encrypt":
			// encrypt 경우 : message + secretword - 97 = encrypted message
			for (int i = 0; i < BASE_LEN; i++) {
				char enc = getEncDec(encdec, message[i], secret[i]);
				encdecMessage[i] = enc;
			}

			startIndex = getStartIndex(rotate, BASE_LEN);

			String result = "";
			for (int i = 0; i < BASE_LEN; i++) {
				result += encdecMessage[startIndex++];
				if (startIndex == BASE_LEN) {
					startIndex = 0;
				}
			}
			System.out.println(result);
			break;

		case "decrypt":
			// decrypt 경우 : message = encrypted message - secretword + 97
			startIndex = getStartIndex(rotate * -1, BASE_LEN);
			
			String rotateResult = "";
			for (int i = 0; i < BASE_LEN; i++) {
				rotateResult += message[startIndex++];
				if (startIndex == BASE_LEN) {
					startIndex = 0;
				}
			}

			message = rotateResult.toCharArray();
			String decResult = "";
			for (int i = 0; i < message.length; i++) {
				char dec = getEncDec(encdec, message[i], secret[i]);
				decResult += dec;
			}
			System.out.println(decResult);
			break;
		}
	}

	private static int getStartIndex(int rotate, int length) {
		int startIndex = (rotate) % length;
		startIndex = (rotate < 0) ? (length + startIndex) : (startIndex);
		return startIndex;
	}
	
	private static char getEncDec(String type, char message, char secret) {
		switch(type) {
		case "encrypt":
			char enc = (char) (message + secret - 'a');
			enc = (enc > 'z') ? (char) (enc - 26) : enc;
			return enc;
			
		case "decrypt":
			char dec = (char) (message - secret + 97);
			dec = (dec < 'a') ? (char) (dec + 26) : dec;
			return dec;
		}
		return 0;
	}
}

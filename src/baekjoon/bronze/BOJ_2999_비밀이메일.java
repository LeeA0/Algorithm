package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_2999_비밀이메일_브론즈1
public class BOJ_2999_비밀이메일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String message = br.readLine();
		// 배열의 행
		int R = 1;
		// 배열의 열
		int C = message.length();
		// R을 2부터해서 message의 길이를 R로 나누었을 때 나누어떨어지는 수 C를 찾음
		// 단, C>=R
		for (int i = 2; i < message.length(); i++) {
			int tempC = message.length() / i;
			// R이 C보다 크면 안됨
			if (tempC < i) {
				break;
			}
			if (tempC * i == message.length()) {
				R = i;
				C = tempC;
			}
		}

		// 암호를 복호화할 배열
		char[][] messageArray = new char[R][C];
		// 메세지를 세로부터 채움
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				messageArray[i][j] = message.charAt(R * j + i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(messageArray[i][j]);
			}
		}
		System.out.println(sb.toString());
	}
}

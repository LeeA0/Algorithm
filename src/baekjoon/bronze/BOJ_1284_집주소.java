package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_1284_집주소_브론즈3
public class BOJ_1284_집주소 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] number = { 4, 2, 3, 3, 3, 3, 3, 3, 3, 3 };
		String num;
		// 0이 나올때까지 반복
		while (!(num = br.readLine()).equals("0")) {
			// 맨 처음 여백
			int answer = 1;
			for (int i = 0; i < num.length(); i++) {
				// 숫자의 너비와 뒤에 붙는 여백을 더함
				answer += number[num.charAt(i) - '0'] + 1;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}

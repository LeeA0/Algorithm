package baekjoon.bronze;

import java.util.Scanner;

//백준_문자열반복_2675_브론즈2
public class BOJ_2675_문자열반복 {
	static int T, N;
	static char[] S;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			N = scan.nextInt();
			S = scan.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < S.length; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(S[i]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}

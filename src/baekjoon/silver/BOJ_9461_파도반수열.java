package baekjoon.silver;

import java.util.Scanner;

//백준_파도반수열_9461_실버3
public class BOJ_9461_파도반수열 {
	static int T, N;
	static long[] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			N = scan.nextInt();
			dp = new long[N + 1];
			dp[0] = 0;
			dp[1] = 1;
			if (N >= 2) {
				dp[2] = 1;
				for (int i = 3; i <= N; i++) {
					dp[i] = dp[i - 2] + dp[i - 3];
				}
			}
			System.out.println(dp[N]);
		}
	}
}

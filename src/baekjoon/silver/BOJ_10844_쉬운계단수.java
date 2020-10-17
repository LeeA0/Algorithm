package baekjoon.silver;

import java.util.Scanner;

//백준_쉬운 계단 수_10844_실버1
public class BOJ_10844_쉬운계단수 {
	static int N;
	static long[][] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		dp = new long[N + 1][10];
		// n=1일 때 값 넣기
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				//더할 때 값이 long범위를 넘어갈 수 있으므로 사전에 10억을 나눠준다.
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % 1000000000;
				} else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % 1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		sum %= 1000000000;
		System.out.println(sum);
	}
}

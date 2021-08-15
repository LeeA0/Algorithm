package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ_서로다른자연수의합_9764_실버1
public class BOJ_9764_서로다른자연수의합 {
	// 1과 2는 무조건 한 개
	// 3은 1+2와 3이 있다 -> 1~2의 숫자, 1~3의 숫자에서 3가 될 수 있는 경우의 수
	// 4는 1+3과 4가 있다 -> 1~3의 숫자, 1~4의 숫자에서 4가 될 수 있는 경우의 수
	// 5는 2+3, 1+4, 5 -> 1~3의 숫자, 1~4의 숫자, 1~5의 숫자에서 5가 될 수 있는 경우의 수
	// ...
	// 8
	// => 1~4 : 1+3+4 => 1~3으로 4를 만든 경우의 수
	// 1~5 : 3+5, 1+2+5 => 1~4로 3을 만든 경우의 수
	// 1~6 : 2+6 => 1~5로 2를 만든 경우의 수
	// 1~7 : 1+7 => 1~6으로 1을 만든 경우의 수
	// 1~8 : 8
	// => dp[i][j] = if i<j: dp[i][j-1]
	// else dp[i][j-1]+dp[i-j][j-1]
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][N + 1];
			dp[0][0] = 1;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 1; j < dp[i].length; j++) {
					dp[i][j] = dp[i][j - 1];
					if (i >= j) {
						dp[i][j] += dp[i - j][j - 1];
						dp[i][j] %= 100999;
					}
				}
			}
			System.out.println(dp[N][N]);
		}
	}
}

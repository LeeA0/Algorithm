package baekjoon.silver;

import java.util.Scanner;

//BOJ_2Xn타일링2_11727_실버3
public class BOJ_11727_2n타일링2 {
	static int n;
	static int[] dp;
	final static int P = 10007;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % P;
		}
		System.out.println(dp[n]);
	}
}

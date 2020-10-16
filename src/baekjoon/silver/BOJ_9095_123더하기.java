package baekjoon.silver;

import java.util.Scanner;

//백준_1,2,3더하기_9095_실버3
public class BOJ_9095_123더하기 {
	static int T, n, count;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			n = scan.nextInt();
			count = 0;
			dfs(0);
			System.out.println(count);
		}
	}

	private static void dfs(int sum) {
		if (sum > n) {
			return;
		}
		if (sum == n) {
			count++;
			return;
		}
		dfs(sum + 1);
		dfs(sum + 2);
		dfs(sum + 3);
	}

}

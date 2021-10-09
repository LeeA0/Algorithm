package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1455_뒤집기2_실버2
public class BOJ_1455_뒤집기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] coins = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				coins[i][j] = chars[j] == '0' ? true : false;
			}
		}

		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (!coins[i][j]) {
					cnt++;
					reverse(i, j, coins);
				}
			}
		}
		System.out.println(cnt);
	}

	private static void reverse(int x, int y, boolean[][] coins) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				coins[i][j] = !coins[i][j];
			}
		}
	}
}

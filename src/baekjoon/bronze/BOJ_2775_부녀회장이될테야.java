package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apt = new int[k + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				apt[0][i] = i;
			}
			for (int i = 1; i < apt.length; i++) {
				for (int j = 1; j < apt[i].length; j++) {
					apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
				}
			}
			System.out.println(apt[k][n]);
		}
	}
}

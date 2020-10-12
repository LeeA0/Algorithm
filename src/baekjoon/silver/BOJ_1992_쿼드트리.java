package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//백준_쿼드트리_1992_실버1
public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		dfs(0, 0, N);
	}

	private static void dfs(int x, int y, int n) {
		
		int flag = map[x][y];
		boolean div = false;
		a: for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[i][j] != flag) {
					div = true;
					break a;
				}
			}
		}
		if (div) {
			System.out.print("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					dfs(x+n/2*i, y+n/2*j, n / 2);
				}
			}
			System.out.print(")");
		} else {
			System.out.print(flag);
		}
	}
}

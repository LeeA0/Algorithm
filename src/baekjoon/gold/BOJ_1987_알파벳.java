package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_알파벳_1987_골드4
public class BOJ_1987_알파벳 {
	static int R, C, max;
	static char[][] map;
	static boolean[] alphabet;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		alphabet = new boolean[26];

		max = Integer.MIN_VALUE;
		// 이미 0,0을 count했으므로 cnt=1이다.
		alphabet[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		//alphabet[map[x][y] - 'A'] = true;
		if (max < cnt) {
			max = cnt;
		}
		if (cnt >= 26) {
			return;
		}
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny) || alphabet[map[nx][ny] - 'A']) {
				continue;
			}
			alphabet[map[nx][ny] - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			alphabet[map[nx][ny] - 'A'] = false;
		}
		//alphabet[map[x][y] - 'A'] = false;
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}
}

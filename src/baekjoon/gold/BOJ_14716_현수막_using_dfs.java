package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_현수막_14716_골드5
public class BOJ_14716_현수막_using_dfs {
	static int M, N, answer;
	static int[][] map;
	static int[][] dir8 = { { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		map[x][y] = 0;
		for (int[] d : dir8) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (map[nx][ny] == 1) {
				map[nx][ny] = 0;
				dfs(nx, ny);
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

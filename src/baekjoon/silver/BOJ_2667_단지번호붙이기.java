package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//백준_단지번호붙이기_2667_실버1
public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = s[j] - '0';
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j, cnt + 1);
				}
			}
		}
		System.out.println(cnt);
		int[] save = new int[cnt];
		for (int k = 2; k < cnt + 2; k++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == k) {
						sum++;
					}
				}
			}
			save[k - 2] = sum;
		}
		Arrays.sort(save);
		for (int i = 0; i < save.length; i++) {
			System.out.println(save[i]);
		}
	}

	private static void bfs(int x, int y, int cnt) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		map[x][y] = cnt;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == 1) {
					que.offer(new int[] { nx, ny });
					map[nx][ny] = cnt;
				}
			}
		}
	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}
}

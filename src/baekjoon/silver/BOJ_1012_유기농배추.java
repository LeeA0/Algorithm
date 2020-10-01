package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준_유기농배추_1012_실버2
public class BOJ_1012_유기농배추 {
	static int T, M, N, K;
	static int[][] map;
	// 상하좌우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			M = scan.nextInt();
			N = scan.nextInt();
			K = scan.nextInt();

			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				map[b][a] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						cnt++;
						bfs(i, j, cnt + 1);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int x, int y, int cnt) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == 1) {
					map[nx][ny] = cnt;
					que.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

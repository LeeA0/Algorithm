package baekjoon.silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준_영역구하기_2583_실버1
public class BOJ_2583_영역구하기 {
	static int M, N, K, cnt;
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] count;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		K = scan.nextInt();

		map = new int[M][N];

		for (int k = 0; k < K; k++) {
			int y1 = scan.nextInt();
			int x1 = scan.nextInt();
			int y2 = scan.nextInt();
			int x2 = scan.nextInt();

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;
				}
			}
		} // 입력 완료

		cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					cnt++;
					bfs(i, j, cnt + 1);
				}
			}
		}
		count = new int[cnt + 2];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 2; k < cnt + 2; k++) {
					if (map[i][j] == k) {
						count[k]++;
					}
				}
			}
		}
		Arrays.sort(count);

		System.out.println(cnt);
		for (int i = 2; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.print(count[i] + " ");
			}
		}
		System.out.println();
	}

	public static void bfs(int x, int y, int ct) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		map[x][y] = ct;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == 0) {
					que.offer(new int[] { nx, ny });
					map[nx][ny] = ct;
				}
			}
		}

	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

}

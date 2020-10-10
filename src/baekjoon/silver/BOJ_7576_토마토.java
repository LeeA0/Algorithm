package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_토마토_7576_실버1
public class BOJ_7576_토마토 {
	static int M, N, day;
	static int[][] tomato;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];

		Queue<int[]> que = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					que.offer(new int[] { i, j });
				}
			}
		}
		day = -1;
		while (!que.isEmpty()) {
			int size = que.size();
			day++;
			for (int i = 0; i < size; i++) {
				int[] curr = que.poll();
				for (int[] d : dir4) {
					int nx = curr[0] + d[0];
					int ny = curr[1] + d[1];
					if (!check(nx, ny)) {
						continue;
					}
					if (tomato[nx][ny] == 0) {
						que.offer(new int[] { nx, ny });
						tomato[nx][ny] = 1;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					day = -1;
				}
			}
		}
		System.out.println(day);
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_아기상어2_17086_다시풀어봄
public class BOJ_17086_아기상어2_re {
	static int N, M, answer;
	static LinkedList<int[]> babyshark;
	static int[][] dist;
	static int[][] dir8 = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	final static int INFINITE = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		babyshark = new LinkedList<int[]>();
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					babyshark.add(new int[] { i, j });
				} else {
					dist[i][j] = INFINITE;
				}
			}
		}

		answer = 0;
		for (int i = 0; i < babyshark.size(); i++) {
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(babyshark.get(i));
			while (!que.isEmpty()) {
				int[] curr = que.poll();
				for (int[] d : dir8) {
					int nx = curr[0] + d[0];
					int ny = curr[1] + d[1];
					if (!check(nx, ny)) {
						continue;
					}
					if (dist[nx][ny] > dist[curr[0]][curr[1]] + 1) {
						dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
						que.offer(new int[] { nx, ny });
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = Math.max(answer, dist[i][j]);
			}
		}
		System.out.println(answer);
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

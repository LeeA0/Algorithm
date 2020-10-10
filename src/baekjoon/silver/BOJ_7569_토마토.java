package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_토마토_7569_실버1
public class BOJ_7569_토마토 {
	static int M, N, H, answer;
	static int[][][] tomato;
	// 위,아래,앞,왼쪽,오른쪽,뒤
	static int[][] dir6 = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[H][N][M];
		int count = 0;
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 1) {
						que.offer(new int[] { i, j, k });
						count++;
					}
				}
			}
		}
		answer = -1;
		if (count != H * N * M) {
			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int[] curr = que.poll();
					for (int[] d : dir6) {
						int nz = curr[0] + d[0];
						int nx = curr[1] + d[1];
						int ny = curr[2] + d[2];
						if (!check(nz, nx, ny)) {
							continue;
						}
						if (tomato[nz][nx][ny] == 0) {
							tomato[nz][nx][ny] = 1;
							que.offer(new int[] { nz, nx, ny });
						}
					}
				}
				answer++;
			}
			
			// count
			a: for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (tomato[k][i][j] == 0) {
							answer = -1;
							break a;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static boolean check(int z, int x, int y) {
		if (z >= 0 && z < H && x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_마법사상어와파이어스톰_20058_골드4
public class BOJ_20058_마법사상어와파이어스톰 {
	static int N, Q, M, sumIce, bigIce;
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		M = (int) Math.pow(2, N);
		map = new int[M][M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int q = 0; q < Q; q++) {
			int L = Integer.parseInt(st.nextToken());
			if (L != 0) {
				int step = (int) Math.pow(2, L);
				// 회전
				for (int i = 0; i < M; i += step) {
					for (int j = 0; j < M; j += step) {
						rotation(i, j, step);
					}
				}
			}
			meltIce();
		}

		// 남아있는 얼음의 합
		sumIce = 0;
		// 가장 큰 덩어리 크기
		bigIce = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		System.out.println(sumIce + "\n" + bigIce);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		int cnt = 0;
		sumIce += map[x][y];
		map[x][y] = 0;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			cnt++;
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] != 0) {
					que.offer(new int[] { nx, ny });
					sumIce += map[nx][ny];
					map[nx][ny] = 0; // 방문처리
				}
			}
		}
		bigIce = Math.max(bigIce, cnt);
	}

	private static void meltIce() {
		int[][] temp = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				if (map[i][j] != 0) {
					for (int[] d : dir4) {
						int nx = i + d[0];
						int ny = j + d[1];
						if (!check(nx, ny)) {
							continue;
						}
						if (map[nx][ny] != 0) {
							cnt++;
						}
					}
					if (cnt < 3) {
						temp[i][j] = map[i][j] - 1;
					} else {
						temp[i][j] = map[i][j];
					}
				}
			}
		}
		map = temp;
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < M && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

	private static void rotation(int x, int y, int step) {
		int[][] temp_map = new int[step][step];
		for (int i = 0; i < step; i++) {
			for (int j = 0; j < step; j++) {
				temp_map[j][step - 1 - i] = map[i + x][j + y];
			}
		}

		// copy
		for (int i = 0; i < step; i++) {
			for (int j = 0; j < step; j++) {
				map[i + x][j + y] = temp_map[i][j];
			}
		}
	}
}

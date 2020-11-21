package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//완탐
//백준_연구소_14502_골드5
public class BOJ_14502_연구소 {
	static int N, M, max_safe;
	static int[][] map, dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static LinkedList<int[]> null_list, virus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		null_list = new LinkedList<int[]>();
		virus = new LinkedList<int[]>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					null_list.add(new int[] { i, j });
				}
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		max_safe = 0;

		nCr(0, 0);
		
		System.out.println(max_safe);
	}

	private static void nCr(int cnt, int start) {
		// 벽 3개를 다 놓았으면
		if (cnt == 3) {
			// map 깊은 복사
			int[][] map_temp = new int[N][M];
			copy(map_temp);
			// 바이러스 퍼트리기
			for (int[] v : virus) {
				bfs(v, map_temp);
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map_temp[i][j]==0) {
						count++;
					}
				}
			}
			max_safe = Math.max(max_safe, count);
			return;
		}
		for (int i = start; i < null_list.size(); i++) {
			int[] place = null_list.get(i);
			int x = place[0];
			int y = place[1];
			// 해당 위치에 벽을 놓았을 때
			map[x][y] = 1;
			nCr(cnt + 1, i + 1);
			// 해당 위치원위치
			map[x][y] = 0;
		}
	}

	public static void copy(int[][] map_temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map_temp[i][j] = map[i][j];
			}
		}
	}

	public static void bfs(int[] v, int[][] map_temp) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(v);
		while (!que.isEmpty()) {
			int curr[] = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map_temp[nx][ny] == 0) {
					map_temp[nx][ny] = 2;
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

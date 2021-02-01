package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준_감시_15683_골드5
public class BOJ_15683_감시 {
	static int N, M, min_room;
	// 상,하,좌,우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][][] cctvDir = {
			// 1번
			{ { 0 }, { 1 }, { 2 }, { 3 } },
			// 2번
			{ { 0, 1 }, { 2, 3 } },
			// 3번
			{ { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } },
			// 4번
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 }, { 0, 1, 3 } },
			// 5번
			{ { 0, 1, 2, 3 } } };
	static ArrayList<CCTV> list;

	static class CCTV {
		int x;
		int y;
		int num;

		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (0 < map[i][j] && map[i][j] < 6) {
					list.add(new CCTV(i, j, map[i][j]));
				}
			}
		} // 입력완료

		min_room = N * M;

		watchCCTV(map, 0);

		System.out.println(min_room);
	}

	static void watchCCTV(int[][] map, int n) {
		if (n == list.size()) {
			min_room = Math.min(min_room, count(map));
			return;
		}
		int x = list.get(n).x;
		int y = list.get(n).y;
		int num = list.get(n).num - 1;
		for (int i = 0; i < cctvDir[num].length; i++) {
			int[][] temp = new int[N][M];
			copy(temp, map);
			watch(temp, cctvDir[num][i], x, y);
			watchCCTV(temp, n + 1);
		}
	}

	static void watch(int[][] temp, int[] dir, int x, int y) {
		for (int d : dir) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += dir4[d][0];
				ny += dir4[d][1];
				if (!check(nx, ny) || temp[nx][ny] == 6)
					break;
				temp[nx][ny] = 7;
			}
		}
	}

	static boolean check(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}

	static void copy(int[][] temp, int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

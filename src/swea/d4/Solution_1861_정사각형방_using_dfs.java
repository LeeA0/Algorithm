package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_정사각형방_1861_D4
public class Solution_1861_정사각형방_using_dfs {
	static int T, N, max_count, max_room;
	static int[][] room, visit;
	// 상,하,좌,우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(temp[j]);
				}
			}
			visit = new int[N][N];
			// 이동
			max_count = -9999;
			max_room = 99999;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0)
						dfs(i, j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max_count < visit[i][j]) {
						max_count = visit[i][j];
						max_room = room[i][j];
					}
					if(max_count==visit[i][j]&&max_room>room[i][j]) {
						max_room = room[i][j];
					}
				}
			}
			StringBuilder sb = new StringBuilder("#").append(t).append(" ").append(max_room).append(" ")
					.append(max_count);
			System.out.println(sb.toString());
		}
	}

	private static void dfs(int cx, int cy) {
		visit[cx][cy] = 1;
		for (int[] d : dir4) {
			int nx = cx + d[0];
			int ny = cy + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (room[nx][ny] == room[cx][cy] + 1) {
				if (visit[nx][ny] == 0) {
					dfs(nx, ny);
				}
				visit[cx][cy] = Math.max(visit[cx][cy], visit[nx][ny] + 1);
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N & y >= 0 && y < N)
			return true;
		return false;
	}
}

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_섬의개수_4963_실버2
public class BOJ_4963_섬의개수_using_dfs {
	// 상,하,좌,우,상좌,상우,하좌,하우
	static int[][] dir8 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int w, h;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0) {
				break;
			}
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j, cnt + 1);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		map[x][y] = cnt;
		for (int[] d : dir8) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if(map[nx][ny]==1) {
				dfs(nx,ny,cnt);
			}
		}
	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
			return true;
		}
		return false;
	}
}

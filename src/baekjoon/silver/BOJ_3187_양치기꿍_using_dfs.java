package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_양지기꿍_3187_실버2
public class BOJ_3187_양치기꿍_using_dfs {
	static int R, C, answer_sheep, answer_wolf,sheep,wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().trim().toCharArray();
		}

		visited = new boolean[R][C];

		answer_sheep = 0;
		answer_wolf = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && map[i][j] != '.' && !visited[i][j]) {
					sheep=0;
					wolf=0;
					
					dfs(i, j);

					if (wolf >= sheep) {
						answer_wolf += wolf;
					} else {
						answer_sheep += sheep;
					}
				}
			}
		}
		System.out.println(answer_sheep + " " + answer_wolf);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		if (map[x][y] == 'v') {
			wolf++;
		} else if (map[x][y] == 'k') {
			sheep++;
		}
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (!visited[nx][ny] && map[nx][ny] != '#') {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}
}
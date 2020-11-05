package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_양지기꿍_3187_실버2
public class BOJ_3187_양치기꿍 {
	static int R, C, answer_sheep, answer_wolf;
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
					bfs(i, j);
				}
			}
		}
		System.out.println(answer_sheep + " " + answer_wolf);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		visited[x][y] = true;

		int sheep = 0;
		int wolf = 0;

		if (map[x][y] == 'v') {
			wolf++;
		} else if (map[x][y] == 'k') {
			sheep++;
		}

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (!visited[nx][ny] && map[nx][ny] != '#') {
					que.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					if (map[nx][ny] == 'v') {
						wolf++;
					} else if (map[nx][ny] == 'k') {
						sheep++;
					}
				}
			}
		}
		if (wolf >= sheep) {
			answer_wolf += wolf;
		} else {
			answer_sheep += sheep;
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}
}

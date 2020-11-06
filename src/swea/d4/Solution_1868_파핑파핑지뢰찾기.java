package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//bfs로 풀거면 visited가 필수!! 너비 우선 탐색을 하면서 que에 중복이 다수 들어간다.
//dfs로 풀거면 visited없어도 된다.
//SW_파핑파핑지뢰찾기_1868_D4
public class Solution_1868_파핑파핑지뢰찾기 {
	static int T, N, answer;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir8 = { { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().trim().toCharArray();
			} // 입력 완료

			visited = new boolean[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && check_bomb(i, j)) {
						bfs(i, j);
						answer++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						answer++;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static boolean check_bomb(int x, int y) {
		for (int[] d : dir8) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (map[nx][ny] == '*') {
				return false;
			}
		}
		return true;
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			int cnt = 0;
			for (int[] d : dir8) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == '*') {
					cnt++;
				}
			}
			map[curr[0]][curr[1]] = (char) (cnt + '0');
			if (cnt == 0) {
				for (int[] d : dir8) {
					int nx = curr[0] + d[0];
					int ny = curr[1] + d[1];
					if (!check(nx, ny) || map[nx][ny] != '.' || visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					que.offer(new int[] { nx, ny });
				}
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}
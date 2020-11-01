package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//SW_보급로_1249_D4
public class Solution_1249_보급로 {
	static int T, N;
	static int[][] map;
	static int[][] visited;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int infinite = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}

			visited = new int[N][N];
			// visited초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], infinite);
			}
			visited[0][0]=0;

			// 입력완료
			bfs(0, 0);
			System.out.println("#" + t + " " + visited[N - 1][N - 1]);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				int temp = visited[curr[0]][curr[1]] + map[nx][ny];
				if (visited[nx][ny] > temp) {
					visited[nx][ny] = temp;
					que.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

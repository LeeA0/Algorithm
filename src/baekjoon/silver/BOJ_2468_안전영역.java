package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_안전영역_2468_실버1
public class BOJ_2468_안전영역 {
	static int[][] map;
	static int[][] visited;
	static int N, max_h, answer;
	static int dir4[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new int[N][N];

		max_h = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_h = Math.max(max_h, map[i][j]);
			}
		}
		int answer = 0;
		for (int k = 0; k <= max_h; k++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k) {
						visited[i][j] = 1;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 1) {
						cnt++;
						bfs(i, j, k, cnt+1);
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	private static void bfs(int x, int y, int k ,int cnt) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		visited[x][y] = cnt;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0]+d[0];
				int ny = curr[1]+d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (visited[nx][ny]==1) {
					que.offer(new int[] { nx, ny });
					visited[nx][ny] = cnt;
				}
			}
		}
	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}

		return false;
	}
}

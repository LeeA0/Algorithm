package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_치즈도둑_7733_D4
public class Solution_7733_치즈도둑 {
	static int[][] cheese;
	static int[][] eated;
	static int T, N, max_d, answer;
	static int dir4[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			cheese = new int[N][N];
			eated = new int[N][N];

			max_d = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					max_d = Math.max(max_d, cheese[i][j]);
				}
			}
			int answer = 0;
			for (int k = 0; k <= max_d; k++) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] > k) {
							eated[i][j] = 1;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (eated[i][j] == 1) {
							cnt++;
							bfs(i, j, k, cnt + 1);
						}
					}
				}
				answer = Math.max(answer, cnt);
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void bfs(int x, int y, int k, int cnt) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		eated[x][y] = cnt;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (eated[nx][ny] == 1) {
					que.offer(new int[] { nx, ny });
					eated[nx][ny] = cnt;
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
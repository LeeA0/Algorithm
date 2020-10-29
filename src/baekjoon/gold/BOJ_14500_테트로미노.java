package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_테트로미노_14500_골드5
public class BOJ_14500_테트로미노 {
	static long merong;
	static int N, M, max;
	static int map[][];
	static boolean[][] visited;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1000을 넘지 않는 '자연수';
		max = 0;

		// 어처피 처음 칸에서 4칸만 가면됨 ->dfs
		// ㅡ,ㅁ,L,번개 모양만 해당
		// ㅜ 모양은 따로 비교
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, map[i][j]);
			}
		}

		// ㅜ모양은 3방탐색!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 3방향 씩 4번 탐색 ㅓ -> ㅜ -> ㅗ -> ㅏ
				for (int k = 0; k < 4; k++) {
					int sum = map[i][j];
					// 중심으로 부터 3방향만 볼 것.
					for (int l = k; l < k + 3; l++) {
						int nx = i + dir4[l % 4][0];
						int ny = j + dir4[l % 4][1];
						// 하나라도 못가는 곳이 있으면 이 모양은 안되는 것.
						if (!check(nx, ny)) {
							break;
						}
						sum += map[nx][ny];
					}
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
		System.out.println(merong);
	}

	public static void dfs(int x, int y, int cnt, int sum) {
		merong++;
		// 4칸 다 갔으면 현재 최대값과 비교
		if (cnt == 3) {
			if (sum > max) {
				System.out.println(max);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(visited[i][j]+"\t");
					}
					System.out.println();
				}
				System.out.println("===================");
			}
			max = Math.max(max, sum);

			return;
		}
		visited[x][y] = true;
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (!visited[nx][ny]) {
				dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
			}
		}
		visited[x][y] = false;
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

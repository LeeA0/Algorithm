package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_아기상어2_17086_실버1_다시풀기 ㅠㅠㅠ
public class BOJ_17086_아기상어2 {
	static int N, M, answer;
	static int[][] map;
	static int[][] dir8 = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}

		answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[][] visited = new int[N][M];
		que.offer(new int[] { x, y });
		visited[x][y] = 1;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir8) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (visited[nx][ny] == 0) {
					// bfs이므로 먼저오는게 최소값이므로 min처리 안해줘도 됨.
					visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
					// 아기 상어를 만나면 안전거리를 계산하고 끝냄 
					if (map[nx][ny] == 1) {
						// 맨처음 1을 더해줬으므로 1을 빼줌
						answer = Math.max(answer, visited[nx][ny] - 1);
						return;
					}
					// 아니면 해당 지점을 que에 넣어주고 계속 진행
					else {
						que.offer(new int[] { nx, ny });
					}
				}
			}
		}

	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

}

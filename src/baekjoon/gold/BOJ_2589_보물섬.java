package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_보물섬_2589_골드5
public class BOJ_2589_보물섬 {
	static int N, M, max;
	// 상하좌우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구현하세요.
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력완료

		// 최단거리로 이동하는데 있어 가장 긴 시간을 저장하는 변수
		// (=보물과 보물사이의 최단거리)
		max = 0;

		// 출발지점인 육지를 찾음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					// visited초기화
					visited = new boolean[N][M];
					// 각 L에서 갈 수 있는 곳까지 이동
					bfs(i, j);
				}
			}
		}

		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		visited[x][y] = true;
		int cnt = -1;
		while (!que.isEmpty()) {
			int size = que.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				int[] curr = que.poll();
				for (int[] d : dir4) {
					int nx = curr[0] + d[0];
					int ny = curr[1] + d[1];
					if (!check(nx, ny)) {
						continue;
					}
					// 바다가 아니고 이미 방문하지않았다면
					if (map[nx][ny] != 'W' && !visited[nx][ny]) {
						que.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}
		max = Math.max(max, cnt);
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

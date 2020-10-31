package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_녹색옷입은애가젤다지_4485_골드4
public class BOJ_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int infinite = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		while (true) {
			t++;
			N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Problem ").append(t).append(": ").append(bfs(0, 0));
			System.out.println(sb.toString());
		}
	}

	public static int bfs(int x, int y) {
		// 링크가 해당 칸에 지나갈 떄 잃는 최소금액 저장
		int[][] visited = new int[N][N];
		// 제일 큰 금액으로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], infinite);
		}
		// 링크가 시작부터 잃고 가는 돈 저장
		visited[x][y] = map[x][y];

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
				if (temp < visited[nx][ny]) {
					visited[nx][ny] = temp;
					que.offer(new int[] { nx, ny });
				}
			}
		}
		return visited[N-1][N-1];
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

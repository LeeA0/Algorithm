package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_치즈_2638_골드4
public class BOJ_2638_치즈 {
	static int N, M;
	static char[][] cheese;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = st.nextToken().charAt(0);
			}
		}

		// 외부공기를 0,0부터 2로 채움
		fill_air(0, 0);

		int hour = 0;

		while (true) {
			boolean isEnd = true;
			hour++;
			// 치즈가 녹음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 'c') {
						cheese[i][j] = '2';
						// 치즈가 사라졌을 때 주변을 탐색하여
						// 내부공기 0을 외부공기 2로 변경
						fill_air(i, j);
					}
				}
			}
			// 녹을 치즈 설정
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == '1') {
						isMelt(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == '1') {
						isEnd = false;
					}
				}
			}
			if (isEnd) {
				break;
			}
		}
		System.out.println(hour);
	}

	private static void fill_air(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		cheese[x][y] = '2';
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (cheese[nx][ny] == '0') {
					que.offer(new int[] { nx, ny });
					cheese[nx][ny] = '2';
				}
			}
		}

	}

	private static void isMelt(int x, int y) {
		int count = 0;
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!check(nx, ny)) {
				continue;
			}
			if (cheese[nx][ny] == '2') {
				count++;
			}
		}
		if (count >= 2) {
			cheese[x][y] = 'c';
		}

	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return true;
		}
		return false;
	}
}

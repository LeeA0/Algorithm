package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_마법사상어와토네이도_20057_골드4
public class BOJ_20057_마법사상어와토네이도 {
	static int N, answer;
	static int[][] map;

	static class dustPercent {
		int x;
		int y;
		double percent;

		public dustPercent(int x, int y, double percent) {
			super();
			this.x = x;
			this.y = y;
			this.percent = percent;
		}
	}

	static dustPercent[][] dp = { { // 토네이도 방향이 왼쪽일 때
			new dustPercent(-1, 1, 0.01), new dustPercent(-1, 0, 0.07), new dustPercent(-1, -1, 0.1),
			new dustPercent(-2, 0, 0.02), new dustPercent(0, -2, 0.05), new dustPercent(2, 0, 0.02),
			new dustPercent(1, -1, 0.1), new dustPercent(1, 0, 0.07), new dustPercent(1, 1, 0.01) },
			{ // 토네이도 방향이 아래일떄
					new dustPercent(-1, -1, 0.01), new dustPercent(0, -1, 0.07), new dustPercent(1, -1, 0.1),
					new dustPercent(0, -2, 0.02), new dustPercent(2, 0, 0.05), new dustPercent(0, 2, 0.02),
					new dustPercent(1, 1, 0.1), new dustPercent(0, 1, 0.07), new dustPercent(-1, 1, 0.01) },
			{ // 토네이도 방향이 오른쪽일 때
					new dustPercent(1, -1, 0.01), new dustPercent(1, 0, 0.07), new dustPercent(1, 1, 0.1),
					new dustPercent(2, 0, 0.02), new dustPercent(0, 2, 0.05), new dustPercent(-2, 0, 0.02),
					new dustPercent(-1, 1, 0.1), new dustPercent(-1, 0, 0.07), new dustPercent(-1, -1, 0.01) },
			{ // 토네이도 방향이 위쪽일 때
					new dustPercent(1, 1, 0.01), new dustPercent(0, 1, 0.07), new dustPercent(-1, 1, 0.1),
					new dustPercent(0, 2, 0.02), new dustPercent(-2, 0, 0.05), new dustPercent(0, -2, 0.02),
					new dustPercent(-1, -1, 0.1), new dustPercent(0, -1, 0.07), new dustPercent(1, -1, 0.01) } };

	static int[][] dir4 = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 좌하우상

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료
		int nx = N / 2;
		int ny = N / 2;
		int d = 0;
		answer = 0;
		// 한 행을 제외한 나머지 부분을 달팽이 방향으로 이동
		for (int i = 0; i < N - 1; i++) {
			// 같은 횟수만큼 다른 방향으로 두번 이동한다.
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < i + 1; j2++) {
					// 한칸 이동
					nx += dir4[d][0];
					ny += dir4[d][1];

					if (map[nx][ny] != 0) {
						dustSpread(nx, ny, d);
						print();
					}
				}
				// 방향 전환
				d = (d + 1) % 4;
			}
		}
		// 마지막 한줄 이동
		for (int i = 0; i < N - 1; i++) {
			// 한칸 이동
			nx += dir4[d][0];
			ny += dir4[d][1];
			dustSpread(nx, ny, d);
			print();
		}
		System.out.println(answer);
	}

	private static void print() {
		System.out.println("=======================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}

	private static void dustSpread(int x, int y, int d) {
		int temp = 0;
		for (dustPercent dust : dp[d]) {
			int nx = x + dust.x;
			int ny = y + dust.y;
			
			int spread = (int) (map[x][y] * dust.percent);
			temp += spread;
			if (!check(nx, ny)) {
				answer += spread;
				continue;
			}
			map[nx][ny] += spread;
		}
		int nx = x + dir4[d][0];
		int ny = y + dir4[d][1];
		if (!check(nx, ny)) {
			answer += map[x][y] - temp;
		} else {
			map[nx][ny] += map[x][y] - temp;
		}
		map[x][y] = 0;
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

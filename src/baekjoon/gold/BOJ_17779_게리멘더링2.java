package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_게리멘더링2_17779_골드4
public class BOJ_17779_게리멘더링2 {
	static int N;
	static int[][] map, number_map;
	// 상하좌우
	static int[][] dir4 = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	// 대각선
	static int[][] dir2 = { { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료

		int answer = 40001;

		for (int x = 1; x < N; x++) {
			for (int y = 1; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 < N && 0 <= y - d1 && y + d2 < N) {
							number_map = new int[N][N];
							getFive(x, y, d1, d2);
							answer = Math.min(answer, getPersonDiff(x, y, d1, d2));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static void getFive(int x, int y, int d1, int d2) {
		System.out.println(x + " " + y + " " + d1 + " " + d2);
		number_map[x][y] = 5;
		int nx = x;
		int ny = y;
		for (int i = 0; i < d1; i++) {
			nx += dir2[0][0];
			ny += dir2[0][1];
			number_map[nx][ny] = 5;
		}
		for (int i = 0; i < d2; i++) {
			nx += dir2[1][0];
			ny += dir2[1][1];
			number_map[nx][ny] = 5;
		}
		nx = x;
		ny = y;
		for (int i = 0; i < d2; i++) {
			nx += dir2[1][0];
			ny += dir2[1][1];
			number_map[nx][ny] = 5;
		}
		for (int i = 0; i < d1; i++) {
			nx += dir2[0][0];
			ny += dir2[0][1];
			number_map[nx][ny] = 5;
		}

		// 안쪽 채워주기
		nx = x;
		ny = y;
		for (int i = 0; i < d1; i++) {
			nx += dir2[0][0];
			ny += dir2[0][1];
			int fy = ny;
			while (true) {
				fy += 1;
				if (number_map[nx][fy] == 5) {
					break;
				}
				number_map[nx][fy] = 5;
			}
		}
		for (int i = 0; i < d2-1; i++) {
			nx += dir2[1][0];
			ny += dir2[1][1];
			int fy = ny;
			while (true) {
				fy += 1;
				if (number_map[nx][fy] == 5) {
					break;
				}
				number_map[nx][fy] = 5;
			}
		}
	}

	public static int getPersonDiff(int x, int y, int d1, int d2) {
		int personDiff = 0;
		

		return personDiff;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(number_map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=================================================");
	}
}

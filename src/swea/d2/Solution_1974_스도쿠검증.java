package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_스도쿠검증_1974_D2
//D2_스도쿠 검증 -> 도합 45
public class Solution_1974_스도쿠검증 {
	static int T;
	static int[][] sdoku;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			sdoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int can = 1;
			// 가로세로탐색
			a: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (int[] d : dir4) {
						int nx = i + d[0];
						int ny = j + d[1];
						while (check(nx, ny)) {
							if (sdoku[i][j] == sdoku[nx][ny]) {
								can = 0;
								break a;
							}
							nx += d[0];
							ny += d[1];
						}
					}
				}
			}
			// 3*3탐색
			if (can == 1) {
				a: for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						can = threeFind(i * 3, i * 3 + 3, j * 3, j * 3 + 3);
						if (can == 0) {
							break a;
						}
					}
				}
			}
			System.out.println("#" + t + " " + can);
		}
	}

	private static int threeFind(int a, int b, int c, int d) {
		for (int i = a; i < b; i++) {
			for (int j = c; j < d; j++) {
				for (int k = i + 1; k < b; k++) {
					for (int l = j + 1; l < d; l++) {
						if (sdoku[i][j] == sdoku[k][l]) {
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < 9 && ny >= 0 && ny < 9) {
			return true;
		}
		return false;
	}
}

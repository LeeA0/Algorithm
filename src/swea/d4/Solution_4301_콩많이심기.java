package swea.d4;

import java.util.Scanner;

//SW_콩많이심기_4301_D4
public class Solution_4301_콩많이심기 {
	static int N, M, T;
	static int[][] map;
	// 2칸간격의 위치들
	static int[][] dir = { { -2, 0 }, { 2, 0 }, { 0, -2 }, { 0, 2 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			M = scan.nextInt();
			N = scan.nextInt();
			map = new int[N][M];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					boolean can = true;
					for (int[] d : dir) {
						int nx = d[0] + i;
						int ny = d[1] + j;
						if (!check(nx, ny) && map[nx][ny] == 1) {
							can = false;
						}
					}
					if (can) {
						map[i][j] = 1;
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return false;
		}
		return true;
	}
}
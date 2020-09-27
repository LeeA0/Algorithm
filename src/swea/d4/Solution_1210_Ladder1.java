package swea.d4;

import java.util.Scanner;

//SW_Ladder1_1210_D4
public class Solution_1210_Ladder1 {
	static int T = 10, N = 100, map[][];
	// 왼,오,위
	static int[][] dir3 = { { 0, -1 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = 0, y = 0;
		for (int t = 1; t <= T; t++) {
			scan.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

			while (x != 0) {
				// 위
				x += dir3[2][0];
				boolean leftright = false;
				// 왼
				if (0 <= y + dir3[0][1]) 
					while (0 <= y + dir3[0][1] && map[x][y + dir3[0][1]] == 1) {
						y += dir3[0][1];
						leftright = true;
					}
				// 오
				if (!leftright)
					if (y + dir3[1][1] < 100)
						while (y + dir3[1][1] < 100 && map[x][y + dir3[1][1]] == 1) {
							y += dir3[1][1];
						}
			}
			System.out.println("#" + t + " " + y);
		}
	}
}

package swea.d2;

import java.util.Scanner;

//Solution_달팽이숫자_1954_D2
public class Solution_1954_달팽이숫자 {
	static int T, N;
	// 우,하,좌,상
	static int[][] dir4 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			int[][] snail = new int[N][N];

			int x = 0, y = -1, count = 1;
			boolean full = false;

			while (!full) {
				for (int[] d : dir4) {
					x += d[0];
					y += d[1];
					while (0 <= x && x < N && 0 <= y && y < N) {
						if (snail[x][y] == 0) {
							snail[x][y] = count++;
							x += d[0];
							y += d[1];
							if (count > N * N) {
								full = true;
								break;
							}
						} else
							break;
					}
					if (full)
						break;
					x -= d[0];
					y -= d[1];
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}

package swea.d2;

import java.util.Scanner;

//SW_숫자배열회전_1961_D2
public class Solution_1961_숫자배열회전 {
	static int T, N;
	static int[][] array, a90, a180, a270;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();

			array = new int[N][N];
			a90 = new int[N][N];
			a180 = new int[N][N];
			a270 = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					array[i][j] = scan.nextInt();
				}
			}
			rotation(array, a90);
			rotation(a90, a180);
			rotation(a180, a270);
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(a90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(a180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(a270[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void rotation(int[][] a1, int[][] a2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a2[i][j] = a1[N - 1 - j][i];
			}
		}
	}
}

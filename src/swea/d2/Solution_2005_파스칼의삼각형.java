package swea.d2;

import java.util.Scanner;

//SW_파스칼의 삼각형_2005_D2
//파스칼
public class Solution_2005_파스칼의삼각형 {
	static int T, N;
	static int[][] triangle;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			triangle = new int[N][N];
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == i || j == 0) {
						triangle[i][j] = 1;
					} else {
						triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
					}
					System.out.print(triangle[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}

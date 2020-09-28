package swea.d2;

import java.util.Scanner;

//SW_파리퇴치_2001_D2
public class Solution_2001_파리퇴치 {
	static int T, N, M, max_kill;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			max_kill = killfly();
			System.out.println("#" + t + " " + max_kill);
		}
	}

	private static int killfly() {
		int sum = 0, max = -99999;
		//파리채의 맨 왼쪽위를 기준으로 잡았을 때 범위에 벗어나지 않으려면 
		//기준의 x와 y값이 N-M이하여야 한다.
		for (int i = 0; i < N - M + 1; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				sum = 0;
				for (int k = 0; k < M; k++) {
					for (int l = 0; l < M; l++) {
						sum += map[i + k][j + l];
					}
				}
				if (sum > max)
					max = sum;
			}
		}
		return max;
	}
}

package baekjoon.bronze;

import java.util.Scanner;

//백준_색종이_10163_브론즈1
public class BOJ_10163_색종이 {
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[101][101];
		for (int n = 1; n <= N; n++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int w = scan.nextInt();
			int h = scan.nextInt();
			for (int i = a; i < a + w; i++) {
				for (int j = b; j < b + h; j++) {
					map[i][j] = n;
				}
			}
		}
		int[] cnt = new int[N];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] != 0) {
					cnt[map[i][j] - 1]++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(cnt[i]);
		}
	}
}

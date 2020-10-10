package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

//백준_별찍기10_2447_실버1
public class BOJ_2447_별찍기10 {
	static int N;
	static char[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new char[N][N];

		// map초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		star(N, 0, 0);

		// 매우중요!
		// 1길이의 단어를 50000번 넣는 것과 50000길이의 단어를 1번 넣는 것의 시간차이는 크다!
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void star(int n, int x, int y) {
		if (n == 1) {
			map[x/3][y/3]='*';
			return;
		}
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (!(i == x + 1 && j == y + 1)) {
				star(n / 3, i*3, j*3);
				}
			}
		}
	}
}

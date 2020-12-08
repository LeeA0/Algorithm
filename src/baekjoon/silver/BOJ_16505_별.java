package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_별_16505_실버5
public class BOJ_16505_별 {
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int width = (int) Math.pow(2, N);
		map = new boolean[width][width];

		star(width, 0, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width - i; j++) {
				if (map[i][j]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void star(int n, int x, int y) {
		if (n == 1) {
			map[x / 2][y / 2] = true;
			return;
		}
		for (int i = x; i < x + 2; i++) {
			for (int j = y; j < y + 2; j++) {
				if (i == x + 1 && j == y + 1)
					continue;
				star(n / 2, i * 2, j * 2);
			}
		}
	}
}

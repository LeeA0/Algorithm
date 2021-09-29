package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		int[][] snail = new int[N][N];

		int[][] dir4 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, };
		int x = N / 2;
		int y = N / 2;
		int d = 0;

		int num = 1;
		int size = 1;
		while (true) {
			for (int i = 0; i < size; i++) {
				snail[x][y] = num++;
				x += dir4[d][0];
				y += dir4[d][1];
			}
			if (x == -1 && y == 0) {
				break;
			}
			d = (d + 1) % 4;
			if (d == 0 || d == 2) {
				size++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (snail[i][j] == find) {
					x = i + 1;
					y = j + 1;
				}
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(x).append(" ").append(y);
		System.out.println(sb.toString());
	}
}

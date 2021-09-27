package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_11123_양한마리양두마리_실버1
public class BOJ_11123_양한마리양두마리 {
	static char[][] map;
	static int H, W;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#') {
						countSheep(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void countSheep(int x, int y) {
		map[x][y] = '.';
		
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (!isBoundary(nx, ny) || map[nx][ny] == '.') {
				continue;
			}
			countSheep(nx, ny);
		}
	}

	public static boolean isBoundary(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}

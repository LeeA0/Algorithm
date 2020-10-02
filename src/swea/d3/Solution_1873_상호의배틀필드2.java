package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_상호의배틀필드_1873_D3
public class Solution_1873_상호의배틀필드2 {
	// 테스트케이스 수 , 높이, 너비
	static int T, H, W, N;
	static char[][] map;
	static char[] input, key = { 'U', 'D', 'L', 'R', 'S' }, dir = { '^', 'v', '<', '>' };
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상,하,좌,우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] temp = br.readLine().split(" ");
			H = Integer.parseInt(temp[0]);
			W = Integer.parseInt(temp[1]);
			map = new char[H][W];
			int x = 0, y = 0;
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}

			N = Integer.parseInt(br.readLine());

			input = new char[N];
			input = br.readLine().toCharArray();

			for (char in : input) {
				// 이동 키
				for (int i = 0; i < 4; i++) {
					if (in == key[i]) {
						if (check(x + dir4[i][0], y + dir4[i][1]) && map[x + dir4[i][0]][y + dir4[i][1]] == '.') {
							map[x][y] = '.';
							x += dir4[i][0];
							y += dir4[i][1];
						}
						map[x][y] = dir[i];
					}
				}
				// 슈팅 키
				if (in == key[4]) {
					int sx = x, sy = y;
					for (int i = 0; i < 4; i++) {
						if (map[x][y] == dir[i]) {
							while (check(sx + dir4[i][0], sy + dir4[i][1])
									&& !(map[sx][sy] == '*' || map[sx][sy] == '#')) {
								sx += dir4[i][0];
								sy += dir4[i][1];
							}
							if (map[sx][sy] == '*') {
								map[sx][sy] = '.';
							}
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W) {
			return true;
		}
		return false;
	}
}

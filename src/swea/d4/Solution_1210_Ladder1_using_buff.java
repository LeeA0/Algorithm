package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_Ladder1_1210_D4
public class Solution_1210_Ladder1_using_buff {
	static int T = 10, N = 100;
	// 왼,오,위
	static int[][] map, dir3 = { { 0, -1 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			br.readLine();
			map = new int[N][N];

			int x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}

				}
			}
			while (x != 0) {
				x += dir3[2][0];
				boolean leftright = false;
				if (y > 0) {
					while (y > 0 && map[x][y + dir3[0][1]] == 1) {
						y += dir3[0][1];
						leftright = true;
					}
				}
				if (!leftright && y < 99) {
					while (y < 99 && map[x][y + dir3[1][1]] == 1) {
						y += dir3[1][1];
					}
				}
			}
			StringBuilder sb = new StringBuilder("#");
			sb.append(t).append(" ").append(y);
			System.out.println(sb.toString());
		}
	}
}

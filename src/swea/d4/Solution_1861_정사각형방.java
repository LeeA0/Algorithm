package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_정사각형방_1861_D4
//DFS 적용해보기
public class Solution_1861_정사각형방 {
	static int T, N, max_count, max_room;
	static int[][] room;
	// 상,하,좌,우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(temp[j]);
				}
			}
			// 이동
			int x, y;
			max_count = -9999;
			max_room = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = 1;
					int cantgo = 0;
					x = i;
					y = j;
					while (cantgo != 4) {
						cantgo = 0;
						for (int[] d : dir4) {
							if (check(x + d[0], y + d[1]) && room[x + d[0]][y + d[1]] == room[x][y] + 1) {
								x += d[0];
								y += d[1];
								count++;
								break;
							} else {
								cantgo++;
							}
						}
					}
					if (max_count < count) {
						max_count = count;
						max_room = room[i][j];
					}
					if (max_count == count && max_room > room[i][j]) {
						max_room = room[i][j];
					}
				}
			}
			StringBuilder sb = new StringBuilder("#").append(t).append(" ").append(max_room).append(" ")
					.append(max_count);
			System.out.println(sb.toString());
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N & y >= 0 && y < N)
			return true;
		return false;
	}
}

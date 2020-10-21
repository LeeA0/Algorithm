package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정올_오목_1733 
//백준_오목_2615
public class JO_1733_오목 {
	static int ans1, ans2, ans3;
	static int[][] map;
	// 탐색은 왼쪽상단에서 시작하므로 나머지는 필요없음.
	// 좌 하좌 하 하우
	static int[][] dir4 = { { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static boolean end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans1 = 0;
		end = false;
		a: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					five(i, j);
					if (end) {
						break a;
					}
				}
			}
		}
		System.out.println(ans1);
		if (ans1 == 1 || ans1 == 2) {
			System.out.println(ans2 + " " + ans3);
		}
	}

	public static void five(int x, int y) {
		int color = map[x][y];
		for (int[] d : dir4) {
			if (check(x - d[0],y - d[1])) {
				if(map[x - d[0]][y - d[1]] == color)
				continue;
			}
			int cnt = 1;
			int nx = x;
			int ny = y;
			int ax = -1;
			int ay = -1;
			while (true) {
				nx += d[0];
				ny += d[1];
				// 영역에서 벗어나면
				if (!check(nx, ny)) {
					break;
				}
				// 돌이 이어져있으면
				if (map[nx][ny] == color) {
					cnt++;
				} else {
					break;
				}
				if (cnt == 5) {
					ax = nx + 1;
					ay = ny + 1;
				}
			}
			if (cnt == 5) {
				ans1 = color;
				// 상, 좌상, 좌, 좌하인 경우
				if (d[0] == 1 && d[1] == -1) {
					ans2 = ax;
					ans3 = ay;
				} else {
					ans2 = x + 1;
					ans3 = y + 1;
				}
				end = true;
				break;
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < 19 && y >= 0 && y < 19) {
			return true;
		}
		return false;
	}
}

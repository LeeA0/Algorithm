package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_벽돌꺠기_5656
public class Solution_5656_벽돌깨기 {

	static int T, N, W, H, answer;
	static int[][][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[N + 1][H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < W; j++) {
					map[0][i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력완료

			answer = H * W;
			brick_break(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	public static void brick_break(int cnt) {
		if (cnt == N) {
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[cnt][i][j] != 0) {
						count++;
					}
				}
			}
			answer = Math.min(answer, count);
			return;
		}
		for (int i = 0; i < W; i++) {
			// 다음 배열을 초기화
			copy(cnt, cnt + 1);
			// 해당 열에 쏘아서 없앰
			shoot(i, cnt+1);
			// 다음 순서 구슬 발사
			brick_break(cnt + 1);
		}
	}

	private static void copy(int c1, int c2) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[c2][i][j] = map[c1][i][j];
			}
		}
	}

	private static void shoot(int a, int cnt) {
		int x = 0;
		int y = a;
		// 벽돌까지 수직 이동
		while (true) {
			if (!check(x, y)) {
				x -= dir4[1][0];
				y -= dir4[1][1];
				break;
			}
			if (map[cnt][x][y] != 0) {
				break;
			}
			// 아래방향으로 떨어짐
			x += dir4[1][0];
			y += dir4[1][1];
		}
		// 폭파
		boom(x, y, cnt);
		// 재정렬
		int[][] map_temp = new int[H][W];
		for (int j = W - 1; j >= 0; j--) {
			int idx = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (map[cnt][i][j] != 0) {
					map_temp[idx--][j] = map[cnt][i][j];
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[cnt][i][j] = map_temp[i][j];
			}
		}
	}

	private static void boom(int x, int y, int cnt) {
		int dist = map[cnt][x][y];
		for (int[] d : dir4) {
			int nx = x;
			int ny = y;
			map[cnt][nx][ny] = 0;
			for (int j = 1; j < dist; j++) {
				nx += d[0];
				ny += d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[cnt][nx][ny] != 0) {
					if (map[cnt][nx][ny] == 1) {
						map[cnt][nx][ny] = 0;
					} else {
						boom(nx, ny, cnt);
					}
				}
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

package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_재미있는 오셸로 게임_4615_D3
public class Solution_4615_재미있는오셸로게임 {
	static int T, N, M;
	static char[][] map;
	// 상,하,좌,우,상좌,상우,하좌,하우
	static int[][] dir8 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][N];
			// 중앙에
			// WB
			// BW 돌 놓기
			map[N / 2 - 1][N / 2 - 1] = 'W';
			map[N / 2 - 1][N / 2] = 'B';
			map[N / 2][N / 2 - 1] = 'B';
			map[N / 2][N / 2] = 'W';

			int[] count = { 2, 2 };
			// 돌놓는 위치에따라 변경
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int wb = Integer.parseInt(st.nextToken());
				char player1;
				char player2;
				// wb가 1이면 player가 흑돌
				if (wb == 1) {
					player1 = 'B';
					player2 = 'W';
				} else { // wb가 2이면 player가 백돌
					player1 = 'W';
					player2 = 'B';
				}

				// 돌을 놓음
				map[x][y] = player1;
				count[wb - 1]++;// wb=1일 때 wb-1=0(흑돌개수 +1)
								// wb=2일 때 wb-1=1(백돌개수 +1)

				for (int[] d : dir8) {
					boolean can = false;
					int nx = x;
					int ny = y;
					while (true) {
						nx += d[0];
						ny += d[1];

						// 영역을 벗어났거나 공백일때
						if (!check(nx, ny) || map[nx][ny] == 0) {
							break;
						}

						// 자신의 돌을 만나면 그 사이에 있는 돌을 바꿔줄 수 있다!
						if (map[nx][ny] == player1) {
							can = true;
							break;
						}
					}
					// 돌을 바꿔줄 수 있으면
					if (can) {
						nx = x;
						ny = y;
						while (true) {
							nx += d[0];
							ny += d[1];
							// 자신의 돌을 만나면 끝
							if (map[nx][ny] == player1) {
								break;
							}
							map[nx][ny]=player1;
							count[wb - 1]++;// wb=1일 때 wb-1=0(흑돌개수 +1)
											// wb=2일 때 wb-1=1(백돌개수 +1)
							count[wb % 2]--; // wb=1일 때 wb%2=1(백돌개수 -1)
												// wb=2일 때 wb%2=0(흑돌개수 -1)
						}
					}
				}
			}
			System.out.println("#" + t + " " + count[0] + " " + count[1]);
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

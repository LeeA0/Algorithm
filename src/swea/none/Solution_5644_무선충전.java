package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//SW_무선충전_5644
public class Solution_5644_무선충전 {
	static int T, M, A;
	static int[][][] BC;
	static int[] player1_move, player2_move;
	// 정지(0), 상(1), 우(2), 하(3), 좌(4)
	static int[][] dir4 = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			player1_move = new int[M];
			player2_move = new int[M];

			StringTokenizer st1 = new StringTokenizer(br.readLine().trim(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < M; i++) {
				player1_move[i] = Integer.parseInt(st1.nextToken());
				player2_move[i] = Integer.parseInt(st2.nextToken());
			}

			// BC의 개수 A만큼의 맵을 만들어준다.
			BC = new int[10][10][A];
			for (int k = 0; k < A; k++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				for (int i = -c; i <= c; i++) {
					for (int j = 0; j <= c - Math.abs(i); j++) {
						if (check(x + i, y - j)) {
							BC[x + i][y - j][k] = p;
						}
						if (check(x + i, y + j)) {
							BC[x + i][y + j][k] = p;
						}
					}
				}
			} // 입력 완료
			
			// 각 초마다 충전최대량을 저장
			int[] save_max = new int[M + 1];
			int player1_x = 0;
			int player1_y = 0;
			int player2_x = 9;
			int player2_y = 9;

			save_max[0] = getMaxPower(player1_x, player1_y, player2_x, player2_y);

			for (int i = 1; i <= M; i++) {
				// 이동
				player1_x += dir4[player1_move[i - 1]][0];
				player1_y += dir4[player1_move[i - 1]][1];
				player2_x += dir4[player2_move[i - 1]][0];
				player2_y += dir4[player2_move[i - 1]][1];

				// 해당 초의 최대값 저장
				save_max[i] = getMaxPower(player1_x, player1_y, player2_x, player2_y);
			}

			int sum = 0;
			for (int i = 0; i <= M; i++) {
				sum += save_max[i];
			}
			System.out.println("#" + t + " " + sum);
		}
	}

	private static int getMaxPower(int player1_x, int player1_y, int player2_x, int player2_y) {
		LinkedList<int[]> player1_canPower = new LinkedList<int[]>();
		LinkedList<int[]> player2_canPower = new LinkedList<int[]>();
		// 해당 위치에서 받을 수 있는 powerlist를 받음.
		for (int i = 0; i < A; i++) {
			if (BC[player1_x][player1_y][i] != 0) {
				player1_canPower.add(new int[] { i, BC[player1_x][player1_y][i] });
			}
			if (BC[player2_x][player2_y][i] != 0) {
				player2_canPower.add(new int[] { i, BC[player2_x][player2_y][i] });
			}
		}
		Collections.sort(player1_canPower, (o1, o2) -> (o2[1] - o1[1])); // 크기 순으로 정렬
		Collections.sort(player2_canPower, (o1, o2) -> (o2[1] - o1[1])); // 크기 순으로 정렬

		// 둘다 범위안에 들어 있을 때
		if (player1_canPower.size() != 0 && player2_canPower.size() != 0) {
			int max = 0, temp = 0;
			for (int[] p1 : player1_canPower) {
				for (int[] p2 : player2_canPower) {
					if (p1[0] == p2[0]) {
						temp = p1[1];
					} else {
						temp = p1[1] + p2[1];
					}
					max = Math.max(max, temp);
				}
			}
			return max;
		}
		// 둘 중 한 명만 범위에 있을 때
		else if (player1_canPower.size() != 0) {
			return player1_canPower.get(0)[1];
		} else if (player2_canPower.size() != 0) {
			return player2_canPower.get(0)[1];
		}
		// 둘다 범위에 없을 때
		else {
			return 0;
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < 10 && y >= 0 && y < 10) {
			return true;
		}
		return false;
	}

}

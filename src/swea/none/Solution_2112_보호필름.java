package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_보호필름_2112

public class Solution_2112_보호필름 {

	static int T, D, W, K, answer;
	static int[][] cell;
	static int[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			cell = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < W; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력완료

			// K가 1일 때는 무조건 참
			if (K == 1 || check(cell)) {
				System.out.println("#" + t + " 0");
			} else {
				answer = Integer.MAX_VALUE;
				isSelected = new int[D];
				subset(0, 0);
				System.out.println("#" + t + " " + answer);
			}
		}
	}

	private static boolean check(int[][] map) {
		int col_cnt = 0;
		for (int j = 0; j < W; j++) {
			int row_cnt = 1;
			int flag = map[0][j];
			for (int i = 1; i < D; i++) {
				if (flag == map[i][j]) {
					row_cnt++;
					if (row_cnt >= K) {
						col_cnt++;
						break;
					}
				} else {
					row_cnt = 1;
					flag = map[i][j];
				}
			}
		}
		if (col_cnt == W) {
			return true;
		}
		return false;
	}

	private static void subset(int cnt, int spread_cnt) {
		if (spread_cnt > K) {
			return;
		}
		if (spread_cnt >= answer) {
			return;
		}
		if (cnt == D) {
			int[][] temp = new int[D][W];
			copy(temp);

			for (int i = 0; i < D; i++) {
				if (isSelected[i] != 2) {
					spread(temp, i, isSelected[i]);
				}
			}

			if (check(temp)) {
				answer = Math.min(answer, spread_cnt);
			}
			return;
		}
		// 약품 안뿌림
		isSelected[cnt] = 2;
		subset(cnt + 1, spread_cnt);
		// 약품 A를 뿌림
		isSelected[cnt] = 0;
		subset(cnt + 1, spread_cnt + 1);
		// 약품 B를 뿌림
		isSelected[cnt] = 1;
		subset(cnt + 1, spread_cnt + 1);
	}

	private static void spread(int[][] temp, int idx, int flag) {
		for (int j = 0; j < W; j++) {
			temp[idx][j] = flag;
		}
	}

	private static void copy(int[][] temp) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = cell[i][j];
			}
		}
	}

}

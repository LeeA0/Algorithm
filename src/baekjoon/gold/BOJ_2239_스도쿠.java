package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//복잡하게 생각할 필요가 없었다.....
//백트래킹 (완탐!!!!)
//백준_스도쿠_2239_골드4
public class BOJ_2239_스도쿠 {

	static int[] sdoku;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sdoku = new int[81];
		for (int i = 0; i < 9; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < 9; j++) {
				sdoku[i * 9 + j] = temp[j] - '0';
			}
		} // 입력완료
		dfs(0);
	}

	private static boolean dfs(int cnt) {
		if (cnt == 81) {
			print();
			return true;
		}

		if (sdoku[cnt] != 0) {
			if (dfs(cnt + 1)) {
				return true;
			}
		} else {

			for (int i = 1; i < 10; i++) {
				if (check(cnt, i)) {
					sdoku[cnt] = i;
					if (dfs(cnt + 1)) {
						return true;
					} else {
						sdoku[cnt] = 0;
					}
				}
			}
		}
		return false;
	}

	private static boolean check(int cnt, int num) {
		int x = cnt / 9;
		int y = cnt % 9;

		// 숫자 체크
		for (int i = 0; i < 9; i++) {
			// 열방향 숫자 체크
			if (sdoku[i * 9 + y] == num)
				return false;
			// 행방향 숫자 체크
			if (sdoku[x * 9 + i] == num)
				return false;
		}
		// 사각형 숫자 체크
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
				if (sdoku[i * 9 + j] == num)
					return false;
			}
		}

		return true;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sdoku[i * 9 + j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

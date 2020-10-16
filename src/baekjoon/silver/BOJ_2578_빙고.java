package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_빙고_2578_실버5
public class BOJ_2578_빙고 {
	static int[][] bingo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		a: for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < 5; j++) {
				int b = Integer.parseInt(st.nextToken());
				if (find(b)) {
					System.out.println(i * 5 + j + 1);
					break a;
				}
			}
		}
	}

	// 사회자가 부른 숫자 빙고 속에서 찾기
	public static boolean find(int b) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == b) {
					bingo[i][j] = 0;
					if (findbingo(b)) {
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}

	// 빙고 개수 세기
	public static boolean findbingo(int b) {
		int cnt = 0;
		// 우 하 방향 탐색(대각선\)
		if (bingo[0][0] == 0) {
			int ct = 0;
			int nx = 0;
			int ny = 0;
			while (checked(nx, ny)) {
				if (bingo[nx][ny] == 0) {
					ct++;
				} else {
					break;
				}
				nx += 1;
				ny += 1;
			}
			if (ct == 5) {
				cnt++;
			}
		}

		// 하방향 탐색(|)
		for (int i = 0; i < 5; i++) {
			// 현재 맨 위칸이 0으로 바뀌어있는 상태면
			if (bingo[0][i] == 0) {
				int ct = 0;
				int nx = 0;
				int ny = i;
				while (checked(nx, ny)) {
					if (bingo[nx][ny] == 0) {
						ct++;
					} else {
						break;
					}
					nx += 1;
					ny += 0;
				}
				if (ct == 5) {
					cnt++;
				}
			}
		}
		// 우방향 탐색(ㅡ)
		for (int i = 0; i < 5; i++) {
			// 현재 맨 왼쪽칸이 0으로 바뀌어있는 상태면
			if (bingo[i][0] == 0) {
				int ct = 0;
				int nx = i;
				int ny = 0;
				while (checked(nx, ny)) {
					if (bingo[nx][ny] == 0) {
						ct++;
					} else {
						break;
					}
					nx += 0;
					ny += 1;
				}
				if (ct == 5) {
					cnt++;
				}
			}
		}

		// 우 상 방향 탐색(대각선/)
		if (bingo[4][0] == 0) {
			int ct = 0;
			int nx = 4;
			int ny = 0;
			while (checked(nx, ny)) {
				if (bingo[nx][ny] == 0) {
					ct++;
				} else {
					break;
				}
				nx += -1;
				ny += 1;
			}
			if (ct == 5) {
				cnt++;
			}
		}

		if (cnt >= 3) {
			return true;
		}
		return false;
	}

	public static boolean checked(int x, int y) {
		if (x >= 0 && x < 5 && y >= 0 && y < 5) {
			return true;
		}
		return false;
	}
}

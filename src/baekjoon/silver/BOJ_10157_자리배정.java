package baekjoon.silver;

import java.util.Scanner;

//백준_자리배정_10157_실버5
public class BOJ_10157_자리배정 {
	static int C, R, K;
	static int[][] sit;
	// 상,우,하,좌
	static int[][] dir4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		C = scan.nextInt();
		R = scan.nextInt();
		K = scan.nextInt();
		// 좌석 배정이 가능한 경우
		if (K <= R * C) {
			sit = new int[R][C];
			int nx = 0;
			int ny = 0;
			int d = 0;
			for (int i = 1; i <= K; i++) {
				sit[nx][ny] = i;
				// 만약 대기 순서가 K인 관객에게 좌석이 배정되면
				if (i == K) {
					// 출력하고 종료
					// 문제에서는 좌우로 이동하는게 x, 위아래로 이동하는게 y이므로 바꿔서 출력
					System.out.println((ny + 1) + " " + (nx + 1));
					break;
				}

				// 방향대로 이동
				nx += dir4[d][0];
				ny += dir4[d][1];
				if (!check(nx, ny) || sit[nx][ny] != 0) {
					// 이전에 이동한 것을 취소하고
					nx -= dir4[d][0];
					ny -= dir4[d][1];
					// 방향을 바꾼 뒤
					d = (d + 1) % 4;
					// 다시 이동
					nx += dir4[d][0];
					ny += dir4[d][1];
				}
			}
		}
		// 모든 좌석이 배정되어 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우
		else {
			System.out.println(0);
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

}

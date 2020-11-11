package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_주사위굴리기_14499_골드5
public class BOJ_14499_주사위굴리기 {
	static int N, M, x, y, K;
	// 0~3: 옆면, 4: 위, 5: 아래
	static int[] dice;
	static int[][] map;
	// 동,서,북,남
	static int[][] dir4 = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		dice = new int[6];
		st = new StringTokenizer(br.readLine().trim(), " ");
		int nx = x;
		int ny = y;
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken()) - 1;
			nx += dir4[d][0];
			ny += dir4[d][1];
			if (!check(nx, ny)) {
				nx -= dir4[d][0];
				ny -= dir4[d][1];
				continue;
			}

			// 임시 주사위 만들기
			int[] temp = new int[6];
			for (int j = 0; j < 6; j++) {
				temp[j] = dice[j];
			}
			// 주사위 굴리기
			switch (d) {
			case 0:// 동
				dice[0] = temp[3];
				dice[2] = temp[0];
				dice[3] = temp[5];
				dice[5] = temp[2];
				break;
			case 1:// 서
				dice[0] = temp[2];
				dice[2] = temp[5];
				dice[3] = temp[0];
				dice[5] = temp[3];
				break;
			case 2:// 북
				dice[0] = temp[4];
				dice[1] = temp[0];
				dice[4] = temp[5];
				dice[5] = temp[1];
				break;
			case 3:// 남
				dice[0] = temp[1];
				dice[1] = temp[5];
				dice[4] = temp[0];
				dice[5] = temp[4];
				break;
			}

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[5];
			} else {
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}

			sb.append(dice[0]).append("\n");
		}
		System.out.print(sb);
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

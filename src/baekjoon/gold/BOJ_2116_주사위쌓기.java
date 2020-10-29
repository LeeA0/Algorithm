package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_주사위쌓기_2116_골드5
public class BOJ_2116_주사위쌓기 {
	static int N, answer;
	static int[][] dice;
	// 마주보는 변들의 인덱스
	static int[][] plane = { { 0, 5 }, { 5, 0 }, { 1, 3 }, { 3, 1 }, { 2, 4 }, { 4, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		// 주사위는 6면
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 맨 처음 다이스를 놓는다
		for (int i = 0; i < 6; i++) {
			// 첫번째 주사위는 아랫면 필요 x
			int up = dice[0][plane[i][0]];
			// 남은 면 중 가장 높은 숫자를 더함.
			int max = 0;
			for (int j = 0; j < 6; j++) {
				// 윗면의 쌍일 때
				if (j == plane[i][0] || j == plane[i][1]) {
					continue;
				}
				max = Math.max(max, dice[0][j]);
			}
			putdice(1, max, up);
		}
		System.out.println(answer);
	}

	public static void putdice(int cnt, int sum, int up) {
		if (cnt == N) {
			answer = Math.max(answer, sum);
			return;
		}
		int save_i = 0;
		for (int i = 0; i < 6; i++) {
			// 먼저쌓은 다이스의 윗면과 아랫면이 같아야함.
			if (up == dice[cnt][plane[i][1]]) {
				up = dice[cnt][plane[i][0]];
				save_i = i;
				break;
			}
		}
		// 남은 면 중 가장 높은 숫자를 더함.
		int max = 0;
		for (int j = 0; j < 6; j++) {
			// 윗면 혹은 아랫면의 쌍일 때
			if (j == plane[save_i][0] || j == plane[save_i][1]) {
				continue;
			}
			max = Math.max(max, dice[cnt][j]);
		}
		putdice(cnt + 1, sum + max, up);
	}
}

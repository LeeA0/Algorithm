package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_13567_로봇_실버5
public class BOJ_13567_로봇 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 동 남 서 북
		int[][] dir4 = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		int d = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (command.equals("TURN")) {
				if (num == 0) {
					d = d - 1 < 0 ? d + 3 : d - 1;
				} else {
					d = (d + 1) % 4;
				}
			} else {
				x += dir4[d][0] * num;
				y += dir4[d][1] * num;
				if (!check(x, y, M)) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(x + " " + y);
	}

	public static boolean check(int x, int y, int M) {
		return 0 <= x && x < M && 0 <= y && y < M;
	}
}

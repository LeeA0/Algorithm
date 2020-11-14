package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_톱니바퀴_14891_실버1
public class BOJ_14891_톱니바퀴 {
	static int[][] gear;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = temp[j] - '0';
			}
		}
		K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			// 마주보는 톱니의 극이 다른지 체크
			boolean[] isDiff = new boolean[3];
			for (int j = 0; j < 3; j++) {
				if (gear[j][2] != gear[j + 1][6]) {
					isDiff[j] = true;
				}
			}

			// 선택된 톱니를 방향대로 회전
			rotation(num, dir);
			
			// 왼쪽에 있는 톱니 회전
			int idx = num;
			int d = dir;
			while (idx > 0) {
				idx -= 1;
				d *= -1;
				if (isDiff[idx]) {
					rotation(idx, d);
				} else {
					break;
				}
			}
			// 오른쪽에 있는 톱니 회전
			idx = num;
			d = dir;
			while (idx < 3) {
				idx += 1;
				d *= -1;
				if (isDiff[idx-1]) {
					rotation(idx, d);
				} else {
					break;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			answer += gear[i][0] == 0 ? 0 : Math.pow(2, i);
		}
		System.out.println(answer);
	}

	private static void rotation(int num, int dir) {
		// 시계
		if (dir == 1) {
			int temp = gear[num][7];
			for (int i = 6; i >= 0; i--) {
				gear[num][i + 1] = gear[num][i];
			}
			gear[num][0] = temp;
		}
		// 반시계
		else {
			int temp = gear[num][0];
			for (int i = 1; i < 8; i++) {
				gear[num][i - 1] = gear[num][i];
			}
			gear[num][7] = temp;
		}
	}

}

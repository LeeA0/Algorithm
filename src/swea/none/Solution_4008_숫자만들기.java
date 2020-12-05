package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_숫자만들기_4008
public class Solution_4008_숫자만들기 {
	static int T, N, max, min;
	static int[] num, operator;
	static int[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			operator = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			num = new int[N];
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			isSelected = new int[4];
			nPr(1, num[0]);

			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void nPr(int cnt, int result) {
		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (isSelected[i] >= operator[i]) {
				continue;
			}
			isSelected[i]++;
			switch (i) {
			case 0:
				nPr(cnt + 1, result + num[cnt]);
				break;
			case 1:
				nPr(cnt + 1, result - num[cnt]);
				break;
			case 2:
				nPr(cnt + 1, result * num[cnt]);
				break;
			case 3:
				nPr(cnt + 1, result / num[cnt]);
				break;
			}
			isSelected[i]--;
		}
	}
}

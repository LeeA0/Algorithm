package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_요리사_4012
public class Solution_4012_요리사 {
	static int T, N, R, min;
	static int[][] synergy;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			R = N / 2;
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			isSelected = new boolean[N];
			min = 999999;
			nCr(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void nCr(int cnt, int start) {
		if (cnt == R) {
			int a = 0, b = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (isSelected[i] && isSelected[j]) {
						a += synergy[i][j] + synergy[j][i];
					} else if (!isSelected[i] && !isSelected[j]) {
						b += synergy[i][j] + synergy[j][i];
					}
				}
			}
			int dif = Math.abs(a - b);
			if (min > dif) {
				min = dif;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			nCr(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}
}

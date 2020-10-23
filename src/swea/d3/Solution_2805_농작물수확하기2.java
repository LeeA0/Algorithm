package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//수식사용
//SW_농작물수확하기_2805_D3
public class Solution_2805_농작물수확하기2 {
	static int T, N, answer;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			answer = 0;
			for (int i = 0; i < N; i++) {
				// Math.abs(i - N / 2) + N - 2 * Math.abs(i - N / 2)
				// = N-Math.abs(i - N / 2)
				for (int j = Math.abs(i - N / 2); j < N - Math.abs(i - N / 2); j++) {
					answer += map[i][j];
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}

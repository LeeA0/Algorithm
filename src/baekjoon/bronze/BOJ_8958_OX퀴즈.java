package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_OX퀴즈_8958_브론즈2
public class BOJ_8958_OX퀴즈 {
	static int T, score;
	static char[] ox;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			ox = br.readLine().trim().toCharArray();
			score = 0;
			int s = 0;
			for (int i = 0; i < ox.length; i++) {
				if (ox[i] == 'O') {
					s++;
					score += s;
				} else {
					s = 0;
				}
			}
			System.out.println(score);
		}
	}
}

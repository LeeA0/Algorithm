package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

//SW_조교의 성적 매기기_1983_D2
public class Solution_1983_조교의성적매기기 {
	static int T, N, K;
	static double[] score;
	static String[] s = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
	static String result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			K = scan.nextInt();
			score = new double[N];
			double k_score = 0.0;
			for (int i = 0; i < N; i++) {
				int m = scan.nextInt();
				int f = scan.nextInt();
				int hw = scan.nextInt();
				score[i] = m * 0.35 + f * 0.45 + hw * 0.2;
				if ((i + 1) == K) {
					k_score = score[i];
				}
			}
			Arrays.sort(score);
			int cutline = N / 10;
			for (int i = 0; i < N; i++) {
				if (score[i] == k_score) {
					result = s[9 - i / cutline]; 
					// cutline : 한 점수를 가질 수 있는 학생수
					// i/cutline : N=20명일 때 K=2->(오름차순) i=18, cutline=2 => i/cutline = 9
					// 9 - i/cutline => 0 => A+
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

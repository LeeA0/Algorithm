package baekjoon.silver;

import java.util.Scanner;
//LIS BOJ -> 11053 11055 1965 2565 2568
//백준_가장 긴 증가하는 부분수열_11053_실버2
public class BOJ_11053_가장긴증가하는부분수열 {
	static int N;
	static int[] A;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}

		int[] LIS = new int[N];

		int max=0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
	}
}

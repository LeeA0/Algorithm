package baekjoon.silver;

import java.util.Scanner;

//백준_가장큰증가부분수열_11055_실버2
public class BOJ_11055_가장큰증가부분수열 {
	static int N;
	static int[] A;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}

		// 이때까지 길이를 저장했다면, 이번에는 합을 구해야 하므로 합을 넣어준다..!
		int[] LIS = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			LIS[i] = A[i];
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && LIS[i] < LIS[j] + A[i]) {
					LIS[i] = LIS[j] + A[i];
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
	}
}

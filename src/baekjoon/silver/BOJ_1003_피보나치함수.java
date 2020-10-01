package baekjoon.silver;

import java.util.Scanner;

//백준_피보나치함수_1003_실버3
public class BOJ_1003_피보나치함수 {
	static int T, N;
	// N일때 0과 1의 개수를 저장
	static int[][] fibo;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			fibo = new int[N + 1][2];
			fibo[0][0] = 1;
			fibo[0][1] = 0;
			if (N > 0) {
				fibo[1][0] = 0;
				fibo[1][1] = 1;
				for (int i = 2; i <= N; i++) {
					fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
					fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
				}
			}
			System.out.println(fibo[N][0] + " " + fibo[N][1]);
		}
	}
}

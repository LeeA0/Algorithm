package swea.d3;

import java.util.Scanner;

//SW_조합_5607_D3
public class Solution_5607_조합 {
	final static int P = 1234567891;
	static int T, N, R;
	static long[] factorial;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			R = scan.nextInt();

			factorial = new long[N + 1];
			factorial[1] = 1;
			for (int i = 2; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % P;
			}

			// nCr = (n! % P) * (((n-r)!)^(P-2)) % P + ((r!)^(P-2)) % P
			System.out.println(power(factorial[N - R]) % P);
			System.out.println(power(factorial[R]) % P);
			long answer = (factorial[N] % P * power(factorial[N - R]) % P * power(factorial[R]) % P) % P;
			System.out.println("#" + t + " " + answer);
		}
	}

	public static long power(long num) {
		int p = P - 2;

		long result = 1;
		long multiply = num;

		while (p > 0) {
			if (p % 2 == 1) {
				result = (result % P * multiply % P) % P;
			}
			multiply = (multiply % P * multiply % P) % P;
			p /= 2;
		}
		return result % P;
	}
}

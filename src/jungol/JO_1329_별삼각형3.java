package jungol;

import java.util.Scanner;

//정올_별삼각형3_1329
public class JO_1329_별삼각형3 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		if (N > 100 || N % 2 == 0) {
			System.out.println("INPUT ERROR!");
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < -Math.abs(i - N / 2) + N / 2; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < -2 * Math.abs(i - N / 2) + N; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}

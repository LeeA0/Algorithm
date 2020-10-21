package jungol;

import java.util.Scanner;

//정올_별삼각형2_1719
public class JO_1719_별삼각형2 {
	static int N, M;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		if (N > 100 || N % 2 == 0) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (M) {
			case 1:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < -Math.abs(i - N / 2) + N / 2 + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < Math.abs(i - N / 2); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < -Math.abs(i - N / 2) + N / 2 + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < -Math.abs(i - N / 2) + N / 2; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < 2 * Math.abs(i - N / 2) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < N; i++) {
					if (i < N / 2) {
						for (int j = 0; j < i; j++) {
							System.out.print(" ");
						}
					} else {
						for (int j = 0; j < N / 2; j++) {
							System.out.print(" ");
						}
					}
					for (int j = 0; j < Math.abs(i - N / 2) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;

			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		}
	}
}

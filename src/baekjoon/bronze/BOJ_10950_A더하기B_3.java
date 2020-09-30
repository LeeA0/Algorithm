package baekjoon.bronze;

import java.util.Scanner;

//백준_A+B-3_10950_브론즈3
public class BOJ_10950_A더하기B_3 {
	static int T, A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			A = scan.nextInt();
			B = scan.nextInt();
			System.out.println(A + B);
		}
	}
}
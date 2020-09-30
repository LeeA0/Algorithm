package baekjoon.bronze;

import java.util.Scanner;

//백준_A+B-4_10951_브론즈3
public class BOJ_10951_A더하기B_4 {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			A = scan.nextInt();
			B = scan.nextInt();
			System.out.println(A + B);
		}
	}
}
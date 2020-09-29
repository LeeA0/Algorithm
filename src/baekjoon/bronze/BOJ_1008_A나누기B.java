package baekjoon.bronze;

import java.util.Scanner;

//백준_A/B_1008_브론즈4
public class BOJ_1008_A나누기B {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		System.out.println((double) A / (double) B);
	}
}

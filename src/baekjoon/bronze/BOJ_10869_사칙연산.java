package baekjoon.bronze;

import java.util.Scanner;

//백준_사칙연산_10869_브론즈5
public class BOJ_10869_사칙연산 {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		System.out.println(A / B);
		System.out.println(A % B);
	}
}

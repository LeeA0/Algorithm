package baekjoon.bronze;

import java.util.Scanner;

//백준_A+B-5_10952_브론즈3
public class BOJ_10952_A더하기B_5 {
	static int A, B;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			A = scan.nextInt();
			if(A==0) {
				break;
			}
			B = scan.nextInt();
			System.out.println(A + B);
		}
	}
}
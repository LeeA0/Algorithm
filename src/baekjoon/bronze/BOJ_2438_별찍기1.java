package baekjoon.bronze;

import java.util.Scanner;

//백준_별찍기1_2438_브론즈3
public class BOJ_2438_별찍기1 {
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

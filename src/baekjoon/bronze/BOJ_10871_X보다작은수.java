package baekjoon.bronze;

import java.util.Scanner;

//백준_X보다작은수_10871_브론즈3
public class BOJ_10871_X보다작은수 {
	static int N, X;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		X = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int a = scan.nextInt();
			if (a < X) {
				sb.append(a).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
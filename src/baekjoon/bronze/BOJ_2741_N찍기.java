package baekjoon.bronze;

import java.util.Scanner;

//백준_N찍기_2741_브론즈3
public class BOJ_2741_N찍기 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}

package baekjoon.bronze;

import java.util.Scanner;

//백준_구구단_2739_브론즈3
public class BOJ_2739_구구단 {
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
		}
		System.out.println(sb.toString());
	}
}

package baekjoon.bronze;

import java.util.Scanner;

//백준_기찍N_2742_브론즈3
public class BOJ_2742_기찍N {
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = N; i >= 1; i--) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}

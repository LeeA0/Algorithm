package baekjoon.bronze;

import java.util.Scanner;

//백준_숫자의합_11720_브론즈2
public class BOJ_11720_숫자의합 {
	static int N, sum;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		char[] temp = scan.next().toCharArray();
		for (int i = 0; i < N; i++) {
			sum += (temp[i] - '0');
		}
		System.out.println(sum);
	}
}
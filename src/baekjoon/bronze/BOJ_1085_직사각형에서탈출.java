package baekjoon.bronze;

import java.util.Scanner;

//백준_직사각형에서 탈출_1085_브론즈3
public class BOJ_1085_직사각형에서탈출 {
	static int x, y, w, h, answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y = scan.nextInt();
		w = scan.nextInt();
		h = scan.nextInt();

		answer = Integer.MAX_VALUE;

		answer = Math.min(answer, x);
		answer = Math.min(answer, y);
		if (w - x >= 0) {
			answer = Math.min(answer, w - x);
		}
		if (h - y >= 0) {
			answer = Math.min(answer, h - y);
		}

		System.out.println(answer);
	}
}

package baekjoon.silver;

import java.util.Scanner;

//백준_Z_1074_실버1
public class BOJ_1074_Z {
	static int N, r, c, answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		r = scan.nextInt();
		c = scan.nextInt();

		answer = 0;
		int n = 1 << N;
		int RS = 0;
		int CS = 0;
		int RE = n;
		int CE = n;

		while (n > 1) {
			n = n / 2;
			if (RS <= r && r < RS + n && CS <= c && c < CS + n) {// 1
				RE -= n;
				CE -= n;
			} else if (RS <= r && r < RS + n && CS + n <= c && c < CE) {// 2
				answer += n * n * 1;
				RE -= n;
				CS += n;
			} else if (RS + n <= r && r < RE && CS <= c && c < n + CS) {// 3
				answer += n * n * 2;
				RS += n;
				CE -= n;
			} else {// 4
				RS += n;
				CS += n;
				answer += n * n * 3;
			}
		}
		System.out.println(answer);
	}
}

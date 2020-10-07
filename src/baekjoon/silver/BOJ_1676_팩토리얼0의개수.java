package baekjoon.silver;

import java.util.Scanner;

//백준_팩토리얼 0의 개수_1676_실버3
public class BOJ_1676_팩토리얼0의개수 {
	static int N;
	final static int P = 100000;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int cnt = 0;
		long fac = 1;
		for (int i = 1; i <= N; i++) {
			fac = (fac * i) % P;
			while (fac % 10 == 0) {
				fac /= 10;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

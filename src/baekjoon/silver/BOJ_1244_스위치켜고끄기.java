package baekjoon.silver;

import java.util.Scanner;

//백준_스위치켜고끄기_1244_실버4
public class BOJ_1244_스위치켜고끄기 {
	static int N, M;
	static boolean[] bulb;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		bulb = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			int a = scan.nextInt();
			if (a == 1) {
				bulb[i] = true;
			}
		}
		M = scan.nextInt();
		for (int i = 0; i < M; i++) {
			int gender = scan.nextInt();
			int number = scan.nextInt();
			// 남학생일 때
			if (gender == 1) {
				int n = number;
				while (n <= N) {
					// 토글
					toggle(n);
					n += number;
				}
			}
			// 여학생일 때
			else {
				toggle(number);
				// 기준점이 number-1
				int left = number - 1;
				int right = number + 1;
				while (left >= 1 && right <= N && bulb[left] == bulb[right]) {
					toggle(left);
					toggle(right);
					left -= 1;
					right += 1;
				}

			}
		}
		for (int i = 1; i < N + 1; i++) {
			if (i > 20 && i % 20 == 1) {
				System.out.println();
			}
			System.out.print(bulb[i] ? "1 " : "0 ");
		}
		System.out.println();
	}

	public static void toggle(int n) {
		if (bulb[n]) {
			bulb[n] = false;
		} else {
			bulb[n] = true;
		}
	}
}
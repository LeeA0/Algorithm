package baekjoon.bronze;

import java.util.Scanner;

//백준_벌집2_2292_브론즈2
public class BOJ_2292_벌집 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int cnt = 0;
		int sum = 0;
		while (true) {
			if (sum >= N) {
				break;
			}
			if (cnt == 0) {
				sum += 1;
			} else {
				sum += 6 * cnt;
			}
			cnt++;
		}

		System.out.println(cnt); // 3
	}
}

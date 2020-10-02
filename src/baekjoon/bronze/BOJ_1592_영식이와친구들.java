package baekjoon.bronze;

import java.util.Scanner;

//백준_영식이와 친구들_1592_브론즈2
public class BOJ_1592_영식이와친구들 {
	static int N, M, L;
	static int[] chair;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		L = scan.nextInt();

		chair = new int[N];
		int i = 0;
		int count = 0;
		while (true) {
			chair[i]++;
			// 한 사람이 공을 M번 받으면 끝
			if (chair[i] == M) {
				break;
			}
			// 현재 공을 받은 획수가 홀수번이면
			if (chair[i] % 2 == 1) {
				i = (i + L) % N;
			}
			// 현재 공을 받은 횟수가 짝수번이면
			else {
				if ((i - L) % N >= 0) {
					i = (i - L) % N;
				} else {
					i = N + (i - L) % N;
				}
			}
			// 공을 던진 횟수
			count++;
		}
		System.out.println(count);
	}
}

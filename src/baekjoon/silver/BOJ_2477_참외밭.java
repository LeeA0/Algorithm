package baekjoon.silver;

import java.util.Scanner;

//백준_참외밭_2477_실버5
public class BOJ_2477_참외밭 {
	static int K;
	static int[] dir;
	static int[] dist;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		K = scan.nextInt();
		dir = new int[6];
		dist = new int[6];

		// 홀수 인덱스의 원소 중 제일 큰 하나가 w1, 짝수 인덱스의 원소 중 제일 큰 하나가 h1일 것.
		// w로부터 3인덱스 차이나는 값이 안쪽 작은 사각형의 w2
		// h로부터 3인덱스 차이나는 값이 안쪽 작은 사각형의 h2
		// 밭의 넓이
		// = w1*h1 - w2*h2
		int w1 = 0, h1 = 0;
		int w1_i = 0, h1_i = 0;
		int index;
		for (int i = 0; i < 6; i++) {
			dir[i] = scan.nextInt();
			dist[i] = scan.nextInt();
			if (i % 2 == 0) {
				if (w1 < dist[i]) {
					w1 = dist[i];
					w1_i = i;
				}
			} else {
				if (h1 < dist[i]) {
					h1 = dist[i];
					h1_i = i;
				}
			}
		}
		int w2 = dist[(w1_i + 3) % 6];
		int h2 = dist[(h1_i + 3) % 6];

		//참외의 수  = 밭의 면적 * 1m^2당 참외 수
		int answer = (w1 * h1 - w2 * h2) * K;
		System.out.println(answer);
	}

}
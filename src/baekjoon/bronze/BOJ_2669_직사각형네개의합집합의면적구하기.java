package baekjoon.bronze;

import java.util.Scanner;

//백준_직사각형 네개의 합집합의 면적 구하기_2669_브론즈2
public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	static boolean[][] map;
	static int answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new boolean[101][101];

		for (int k = 0; k < 4; k++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}

		// 네개의 직사각형이 차지하는 면적을 저장할 변수
		answer = 0;

		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}

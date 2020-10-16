package baekjoon.silver;

import java.util.Scanner;

//백준_직사각형_2527_실버1
public class BOJ_2527_직사각형 {
	static int x1, y1, x2, y2, a1, b1, a2, b2;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int k = 0; k < 4; k++) {
			x1 = scan.nextInt();
			y1 = scan.nextInt();
			x2 = scan.nextInt();
			y2 = scan.nextInt();
			a1 = scan.nextInt();
			b1 = scan.nextInt();
			a2 = scan.nextInt();
			b2 = scan.nextInt();

			// 점일 때
			if ((x1 == a2 && y1 == y2) || (x2 == a1 && y1 == b2) || (x2 == a1 && y2 == b1) || (x1 == a2 && y2 == y1)) {
				System.out.println("c");
			}
			// 선분일 떄
			else if (y1 == b2 || x2 == a1 || y2 == b1 || x1 == a2) {
				System.out.println("b");
			}
			// 겹치는 부분이 없을 때
			else if (x1 > a2 || y1 > b2 || x2 < a1 || y2 < b1) {
				System.out.println("d");
			}
			// 직사각형일 때
			else {
				System.out.println("a");
			}
		}
	}
}

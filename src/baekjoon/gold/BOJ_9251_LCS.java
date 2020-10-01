package baekjoon.gold;

import java.util.Scanner;

//백준_9251_LCS_골드5
public class BOJ_9251_LCS {
	static char[] first, second;
	static int[][] LCS;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		first = scan.next().toCharArray();
		second = scan.next().toCharArray();
		// 맨 윗줄과 왼쪽줄은 공집합 처리
		LCS = new int[second.length + 1][first.length + 1];

		for (int i = 1; i <= second.length; i++) {
			for (int j = 1; j <= first.length; j++) {
				// 비교하는 두번째 글자와 첫번째 긑자가 같을때
				if (second[i - 1] == first[j - 1]) {
					// 직전 i-1,j-1위치에서 +1을 해준 값을 넣는다.
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				}
				// 다르다면
				else {
					// 직전열이나 직전행의 값 중 제일 큰 값을 넣는다.
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
//				print();
			}
		}

		System.out.println(LCS[second.length][first.length]);
	}

//	public static void print() {
//		for (int i = 0; i < LCS.length; i++) {
//			for (int j = 0; j < LCS[i].length; j++) {
//				System.out.print(LCS[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("=====================");
//	}
}

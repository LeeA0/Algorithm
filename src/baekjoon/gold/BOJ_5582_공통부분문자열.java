package baekjoon.gold;

import java.util.Scanner;

//백준_공통부분문자열_5582_골드5
public class BOJ_5582_공통부분문자열 {
	static char[] first, second;
	static int[][] LCS;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		first = scan.next().toCharArray();
		second = scan.next().toCharArray();
		LCS = new int[second.length + 1][first.length + 1];

		int max = 0;

		for (int i = 1; i <= second.length; i++) {
			for (int j = 1; j <= first.length; j++) {
				if (second[i - 1] == first[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					max = Math.max(max, LCS[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}

package baekjoon.gold;

import java.util.Scanner;

//백준_LCS2_9252_골드5
public class BOJ_9252_LCS2 {
	static char[] first, second;
	static int[][] LCS;
	// 좌,상
	static int[][] dir2 = { { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		first = scan.next().toCharArray();
		second = scan.next().toCharArray();
		LCS = new int[second.length + 1][first.length + 1];

		for (int i = 1; i <= second.length; i++) {
			for (int j = 1; j <= first.length; j++) {
				if (second[i - 1] == first[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int nx = second.length;
		int ny = first.length;
		int len = LCS[second.length][first.length];

		// 길이출력
		System.out.println(len);

		while (len > 0) {
			if (second[nx - 1] == first[ny - 1]) {
				sb.append(second[nx - 1]);
				nx += -1;
				ny += -1;
				len--;
			} else {
				for (int[] d : dir2) {
					nx += d[0];
					ny += d[1];
					while (true) {
						if(LCS[nx][ny]!=len) {
							nx -= d[0];
							ny -= d[1];
							break;
						}
						nx += d[0];
						ny += d[1];
					}
				}
			}
		}
		
		// 문장출력
		System.out.println(sb.reverse().toString());
	}
}

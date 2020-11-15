package baekjoon.gold;

import java.util.Scanner;

//백준_비밀번호만들기_17218_골드5
public class BOJ_17218_비밀번호만들기 {
	static char[] first, second;
	static int[][] LCS;
	// 좌 상
	static int[][] dir2 = { { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		first = scan.next().toCharArray();
		second = scan.next().toCharArray();
		// 맨 윗줄과 왼쪽줄은 공집합 처리
		LCS = new int[second.length + 1][first.length + 1];

		for (int i = 1; i <= second.length; i++) {
			for (int j = 1; j <= first.length; j++) {
				// 비교하는 두번째 글자와 첫번째 긑자가 같을때
				// -1을 해주는 이유 : LCS배열의 맨 앞의 공백은 first나 second에 없기 때문에 인덱스 초과가 날 수 있다.
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

		// 출력값 저장
		StringBuilder sb = new StringBuilder();
		int len = LCS[second.length][first.length];
		int nx = second.length;
		int ny = first.length;
		while (len > 0) {
			// 두 단어가 같으면
			if (second[nx - 1] == first[ny - 1]) {
				sb.append(second[nx - 1]);
				nx += -1;
				ny += -1;
				len--;
			}
			// 같지 않으면
			else {
				for (int[] d : dir2) {
					nx += d[0];
					ny += d[1];
					while (true) {
						// 이동한 곳의 값이 len값과 다르면
						if (LCS[nx][ny] != len) {
							// 다시 한칸 전으로 돌아오고 break;
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
		System.out.println(sb.reverse().toString());
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
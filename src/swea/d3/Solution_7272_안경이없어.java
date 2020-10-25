package swea.d3;

import java.util.Scanner;

//SW_안경이없어!_7272_D3
public class Solution_7272_안경이없어 {
	static int T;
	static char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
	static char two = 'B';

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] a = scan.next().toCharArray();
			char[] b = scan.next().toCharArray();
			
			//result 초기화
			String result = "SAME";
			
			//길이가 다르면 diff
			if (a.length != b.length) {
				result = "DIFF";
			} else { //길이가 같을 때
				for (int i = 0; i < a.length; i++) {
					//구멍 개수가 다르면diff
					if (holeCount(a[i]) != holeCount(b[i])) {
						result = "DIFF";
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static int holeCount(char a) {
		if (a == two) {
			return 2;
		}
		for (char n : one) {
			if (a == n) {
				return 1;
			}
		}
		// 그 밖의 나머지 알파벳 대문자는 구멍의 개수가 0
		return 0;
	}
}

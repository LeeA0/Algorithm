package swea.d2;

import java.util.Scanner;
//SW_간단한369게임_1926_D2
//369
public class Solution_1926_간단한369게임 {
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = scan.nextInt();
		for (int i = 1; i <= N; i++) {
			boolean clap = false;
			int temp = i;
			for (int k = 10;((temp*10)/k)!=0; k = k * 10) {
				// 일,십,백의 자리 숫자 추출
				int temp2 = (temp % k) / (k / 10);
				if (temp2 == 3 || temp2 == 6 || temp2 == 9) {
					sb.append("-");
					clap = true;
				}
			}
			if (!clap) {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}

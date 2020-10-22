package swea.d2;

import java.util.Scanner;

//SW_패턴마디의길이_2007_D2
//문자패턴
public class Solution_2007_패턴마디의길이 {
	static int T, length;
	static String s;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			s = scan.next();

			length = 1;
			for (int i = 1; i < 10; i++) {
				String a = s.substring(0, i);
				String b = s.substring(i, 2 * i);
				if (!a.equals(b)) {
					length++;
				} else {
					break;
				}
			}
			System.out.println("#" + t + " " + length);
		}
	}
}

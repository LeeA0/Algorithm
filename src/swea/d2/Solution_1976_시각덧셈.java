package swea.d2;

import java.util.Scanner;

//SW_시각 덧셈_1976_D2
public class Solution_1976_시각덧셈 {
	static int T, ss, sb, ms, mb;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			ss = scan.nextInt();
			sb = scan.nextInt();
			ms = scan.nextInt();
			mb = scan.nextInt();

			int es, eb;
			es = ss + ms;
			eb = sb + mb;
			if (eb > 59) {
				eb -= 60;
				es++;
			}
			if (es > 12) {
				es -= 12;
			}
			System.out.println("#"+t+" "+es+" "+eb);
		}
	}
}

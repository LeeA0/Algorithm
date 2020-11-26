package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_수영장_1952
public class Solution_1952_수영장 {
	static int T;
	static int[] fee;
	static int[] month;
	static int[] dp1, dp2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			fee = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}

			month = new int[12];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			} // 입력 완료

			dp1 = new int[12];
			for (int i = 0; i < 12; i++) {
				dp1[i] = Math.min(fee[0] * month[i], fee[1]);
			}
			dp2 = new int[12];
			dp2[0] = dp1[0];
			dp2[1] = dp1[1] + dp2[0];
			for (int i = 2; i < 12; i++) {
				dp2[i] = dp1[i] + dp2[i - 1];
				if (i == 2) {
					dp2[i] = Math.min(fee[2], dp2[i]);
				} else {
					dp2[i] = Math.min(dp2[i - 3] + fee[2], dp2[i]);
				}
			}
			System.out.println("#" + t + " " + (dp2[11] < fee[3] ? dp2[11] : fee[3]));
		} // T
	}
}

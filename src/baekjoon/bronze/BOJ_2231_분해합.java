package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_2231_분해합_브론즈2
public class BOJ_2231_분해합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String stringN = br.readLine();
		int len = stringN.length();
		int N = Integer.parseInt(stringN);

		int M = N - (stringN.charAt(0) - '1');
		if (len > 1) {
			M -= 9 * (len - 1);
		}
		while (N > M) {
			int sum = M;
			String stringM = Integer.toString(M);
			for (int i = 0; i < stringM.length(); i++) {
				sum += stringM.charAt(i) - '0';
			}
			if (sum == N) {
				System.out.println(M);
				return;
			}
			M++;
		}
		System.out.println(0);
	}
}

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		// 5로 나누어 떨어질 때나 음수가 될 때까지 3으로 빼줌
		while (N % 5 != 0 && N > 0) {
			N -= 3;
			cnt++;
		}
		// 음수면 만들 수 없는 수
		if (N < 0) {
			System.out.println(-1);
		}
		// 양수라면 5로 나누어 떨어진다는 것이므로 만들 수 있는 수
		else {
			System.out.println(cnt + N / 5);
		}

		// dp로 풀려고했는데 속도가 더 많이 나옴 ㅎㅎ..
//		int[] dp = new int[N + 1];
//		// 3은 3kg의 설탕 1개
//		dp[3] = 1;
//		// 5는 5kg의 설탕 1개
//		if (N >= 5) {
//			dp[5] = 1;
//		}
//		// N까지 설탕포대 수를 구함
//		for (int i = 6; i <= N; i++) {
//			// i보다 작은 수부터 가능한 포대 수를 찾음
//			for (int j = i - 1; j >= i / 2; j--) {
//				// jkg의 포대 수가 있고 i-j의 포대 수가 있으면
//				if (dp[j] != 0 && dp[i - j] != 0) {
//					// 이미 dp[i]값이 만들 수 있는 경우의 수면 그 중에서도 가장 작은 값을 채택
//					if (dp[i] != 0) {
//						dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
//					}
//					// 아직 만들 수 있었던 경우가 없었다면 무조건 저장
//					else {
//						dp[i] = dp[j] + dp[i - j];
//					}
//				}
//			}
//		}
//		// 0이면 만들 수 없는 것
//		System.out.println(dp[N] == 0 ? -1 : dp[N]);
	}
}

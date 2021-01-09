package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_퇴사_14501_실버4
public class BOJ_14501_퇴사_using_dp {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 퇴사하기 까지의 날짜
		int N = Integer.parseInt(br.readLine().trim());
		// 상담소요 일수와 수익을 한번에 받기 위해 2차원 배열 선언
		int[][] counsel = new int[N][2];
		for (int i = 0; i < N; i++) {
			// 공백으로 나뉘어져 있으므로 StringTokenizer를 이용해 분리 후 넣어줌
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		} // 입력완료

		int[] dp = new int[N+1];
		// 해당 상담을 고를지 말지 결정하기위해 퇴사일 전날부터 거꾸로 계산해줌
		// => 해당 상담을 골랏을 때와 고르지 않았을 때의 수익을 비교할 수 있음
		for (int i = N-1; i >= 0; i--) {
			// 현재날짜와 상담소요 날짜가 퇴사일보다 이전이면
			if(i+counsel[i][0]<=N) {
				// (다음날 비용)과 ((해당 날짜의 소요일수 후 날짜의 수익) + (해당 날짜 수익))을 비교해서 큰 것을 고름
				// ex)    5  6  7
				// 소요일수: 2  1  1
				// 수익:   10 20 10
				// 날짜가 5일 일때  6일과 7일인 수익30이 더 높은지, 5일과 7일인 수익20이 더 높은지 비교(5일에서 2일 후면 7일)
				dp[i] = Math.max(dp[i+1], dp[i+counsel[i][0]]+counsel[i][1]);
			}
			else {
				// 아닌 경우 다음날 값을 그대로 넣어줌
				dp[i] = dp[i+1];
			}
		}
		
		// 0번째에 최대 수익이 저장되어있음
		System.out.println(dp[0]);
	}
}

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1535_안녕_실버2
public class BOJ_1535_안녕_using_dp {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		int[] J = new int[N + 1];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료

		// KnapSack처럼 풀기 위한 dp
		// 행은 사람 수
		// 열은 최대 체력인 100과 같으면 죽는다 했으므로 99까지만 사용
		int[][] dp = new int[N + 1][100];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				// 만약 현재 사람에게 인사하여 뺏기는 체력이 j라는 임시 체력보다 작거나 같다면 남는 체력 안에 다른사람과도 인사할 수 있다
				// 다른 사람과 인사해서 얻는 기쁨과 이때까지 최대 기쁨인 것을 비교해서 최대 값을 저장
				if (L[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], J[i] + dp[i - 1][j - L[i]]);
				}
				// 현재 사람에게 인사하여 뺏기는 체력이 임시 체력보다 크다면 현재 사람에게 인사를 할 수 없으므로
				// 이때까지 인사했던 사람들 중 기쁨이 최대인 사람들의 값을 가져옴 
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		// 맨끝이 주어진 체력에서 최대로 얻을 수 있는 기쁨임
		System.out.println(dp[N][99]);
	}
}

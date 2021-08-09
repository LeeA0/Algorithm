package programmers.level2;

// Programmers_땅따먹기_level2
public class Programmers_땅따먹기 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(solution(land));
	}

	/*
	 * DP로 해결!
	 * dp로 저장한 이때까지 가능한 열이 같지않은 가장 큰 수와 현재 숫자를 더하면 됨
	 * 1 1 1 1
	 * 2 2 2 3
	 * 3 3 3 6
	 * 4 4 4 7
	 * => dp(i,j) = 이전 행에서 j가 같지 않은 숫자 중 가장 큰 값 + land(i,j)
	 */
	static int solution(int[][] land) {
		// 앞 행에서 계산했을 때 최댓값을 저장한 배열
		int[][] dp = new int[land.length][4];
		// dp 초기값 세팅
		for (int i = 0; i < land[0].length; i++) {
			dp[0][i] = land[0][i];
		}
		// 두번쨰 행부터 순회
		for (int i = 1; i < land.length; i++) {
			// 전체 열을 순회하면서 dp값을 구함
			for (int j = 0; j < land[i].length; j++) {
				// 현재 행의 열이 겹치지 않는 이전 행 중 최댓값을 찾음
				int preMax = 0;
				for (int k = 0; k < land[i - 1].length; k++) {
					if (j != k) {
						preMax = Math.max(preMax, dp[i - 1][k]);
					}
				}
				// 최대값과 현재값을 더함
				dp[i][j] = preMax + land[i][j];
			}
		}
		// 맨 마지막 줄 중에 최댓값을 정답으로 반환
		int answer = 0;
		for (int i = 0; i < dp[dp.length - 1].length; i++) {
			answer = Math.max(answer, dp[dp.length - 1][i]);
		}
		return answer;
	}
}

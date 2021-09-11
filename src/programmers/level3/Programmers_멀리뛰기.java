package programmers.level3;

// Programmers_멀리뛰기_level3
public class Programmers_멀리뛰기 {
	public static void main(String[] args) {
		int n = 2000;
		System.out.println(solution(n));
	}

	public static long solution(int n) {
		// 손으로 쓰다보니 피보나치 수열과 같아서 dp로 품
		// 메모리 제한이 빡빡해서 배열의 길이를 3으로 하고 돌려 씀
		long[] dp = new long[3];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i % 3] = (dp[(i + 1) % 3] + dp[(i + 2) % 3]) % 1234567;
		}
		return dp[(n - 1) % 3];
	}
}

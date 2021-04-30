package programmers;

public class Programmers_2xn타일링 {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	// 그리다보니 피보나치 수....
	public static int solution(int n) {
		// 나누는 수
		final int DIV = 1000000007;
		// 이전 사각형 개수를 저장하는 곳
		int[] memo = new int[n+1];

		// 피보나치 수의 0은 1, 1은 1이다
		memo[0] = 1;
		memo[1] = 1;

		// n값이 나올 때까지 더하면서 값을 저장
		for (int i = 2; i <= n; i++) {
			memo[i] = (memo[i - 1] % DIV + memo[i - 2] % DIV) % DIV;
		}

		// n번째 값 출력
		return memo[n];
	}
}

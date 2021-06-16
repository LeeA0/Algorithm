package programmers;

public class Programmers_정수제곱근판별 {
	public static void main(String[] args) {
		final long n = 50000000000000L;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		// 정답을 저장할 변수 선언
		long answer = 0;
		// n의 소숫점을 땐 제곱근을 저장
		long sqrt_n = (long) Math.sqrt(n);
		// n의 제곱근이 양의 정수로 딱 떨어지면
		if (Math.sqrt(n) == sqrt_n) {
			// 제곱근에 1을 더한 숫자의 제곱을 반환
			answer = (sqrt_n + 1) * (sqrt_n + 1);
		}
		// 아니면 -1을 반환
		else {
			answer = -1;
		}
		return answer;
	}
}

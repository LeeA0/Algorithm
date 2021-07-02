package programmers.level1;

// Programmers_자릿수더하기_level1
public class Programmers_자릿수더하기 {
	public static void main(String[] args) {
		int n = 123;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		// 모든 자리수를 돌았을 때 0이되므로 0보다 큰 동안 반복한다
		while (n > 0) {
			// 작은 자리수 숫자부터 더하기위해 n을 10으로나눈 나머지를 더한다
			answer += n % 10;
			// 다음 자리수를 더하기 위해 n을 10으로 나눠준다
			n /= 10;
		}
		return answer;
	}
}

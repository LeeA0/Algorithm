package programmers;

public class Programmers_약수의합 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		// 약수를 더할 변수
		int answer = 0;
		// 제곱근까지 약수를 구하면 나머지 절반도 구할 수 있다
		for (int i = 1; i <= Math.sqrt(n); i++) {
			// 제곱근이면 제곱근 하나만 더한다
			if(i==Math.sqrt(n)) {
				answer+=i;
			}
			// 나눴을 때 나머지가 0이면 그 숫자와 피나눗셈 숫자를 더한다
			else if(n%i==0) {
				answer += i;
				answer += (n/i);
			}
		}
		return answer;
	}
}

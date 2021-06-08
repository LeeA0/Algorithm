package programmers;

//Programmers_소수찾기_level1
public class Programmers_소수찾기 {
	public static void main(String[] args) {
		int n = 1000000;
		System.out.println(solution(n));
	}

	// 에라토스테네스의 체를 이용한다
	public static int solution(int n) {
		int answer = 0;
		// 해당 숫자가 소수인지 체크하는 배열을 생성
		boolean[] isNotPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			// 소수이면
			if (!isNotPrime[i]) {
				// 답을 하나 증가한다
				answer++;
				// 해당 수의 배수를 전부 제거한다
				int idx = i + i;
				while (idx <= n) {
					isNotPrime[idx] = true;
					idx += i;
				}
			}
		}
		return answer;
	}
}

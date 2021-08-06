package programmers.level2;

// Programmers_숫자의표현_level2
public class Programmers_숫자의표현 {
	public static void main(String[] args) {
		int n = 10000;
		System.out.println(solution(n));
	}
	
	/*
	 * 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리 
	 * ex) 15의 약수 => 1,3,5,15 => 4개
	 */

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i += 2) {
			if (n % i == 0) {
				answer++;
			}
		}
		return answer;
	}

	/*
	 * 완탐
	 */
//	public static int solution(int n) {
//		int answer = 0;
//		// 1에서 n까지의 수를 시작점으로 잡는다
//		for (int i = 1; i <= n; i++) {
//			int sum = 0;
//			// i부터 sum이 n보다 같거나 커질 때까지 더함
//			for (int j = i; sum < n; j++) {
//				sum += j;
//				// sum이 n과 같아지면 개수 +1
//				if (sum == n) {
//					answer++;
//					break;
//				}
//			}
//		}
//		return answer;
//	}
}

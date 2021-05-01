package programmers;

import java.util.Arrays;

// Programmers_예산_level1
public class Programmers_예산 {

	public static void main(String[] args) {
		int[] d = { 1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d, budget));
	}
	
	// 간단하게 정렬해서 풀면되는 것을... 재귀를 써보고.. dp를 써봤다...
	// simple is best
	public static int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;
		// 오름차순 정렬
		Arrays.sort(d);
		// 부서 비용이 작은 것부터 넣으면 가장 많은 부서의 요청을 들어줄수 있다
		for (int i = 0; i < d.length; i++) {
			// 현재까지 받아 준 비용의 합에 부서 비용을 더한다
			sum += d[i];
			// 비용의 합이 예산 보다 작으면
			if (sum <= budget) {
				// 부서 수 +1
				answer++;
			}
			// 아니면 멈춤
			else {
				break;
			}
		}

		return answer;
	}
}

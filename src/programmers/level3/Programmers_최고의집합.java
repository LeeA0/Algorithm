package programmers.level3;

import java.util.Arrays;

// Programmers_최고의집합_level3
public class Programmers_최고의집합 {
	public static void main(String[] args) {
		int n = 2;
		int s = 9;
		System.out.println(Arrays.toString(solution(n, s)));
	}

	/*
	 * 더했을 때 s가 되는 n개의 수는 범위 내에서 공평하게 나눠갖고, 남은 나머지를 1씩쪼개서 더해주는 것
	 */
	public static int[] solution(int n, int s) {
		// 나눈 값이 0이면 자연수의 합으로 s를 만들 수 없다
		if (s / n == 0) {
			return new int[] { -1 };
		}

		int[] answer = new int[n];
		int div = s / n;
		int remind = s - div * n;

		for (int i = 0; i < answer.length; i++) {
			if (i < answer.length - remind) {
				answer[i] = div;
			} else {
				answer[i] = div + 1;
			}
		}

		return answer;
	}
}

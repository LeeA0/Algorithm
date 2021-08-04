package programmers.level2;

import java.util.Arrays;

// Programmers_최솟값만들기_level2
public class Programmers_최솟값만들기 {
	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;

		// A,B를 오름차순 정렬
		Arrays.sort(A);
		Arrays.sort(B);

		// A는 0부터, B는 맨 끝부터 조회해서 서로 곱한 값을 answer에 더함
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[B.length - i - 1];
		}

		return answer;
	}
}

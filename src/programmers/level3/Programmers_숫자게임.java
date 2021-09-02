package programmers.level3;

import java.util.Arrays;

// Programmers_숫자게임_level3
public class Programmers_숫자게임 {
	public static void main(String[] args) {
		int[] A = { 1, 2, 7, 8 };
		int[] B = { 1, 2, 6, 7 };
		System.out.println(solution(A, B));
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;

		// A의 가장 큰 숫자와 B의 가장 큰 숫자를 비교하기위해 정렬
		Arrays.sort(A);
		Arrays.sort(B);

		// A의 가장 큰 숫자의 인덱스
		int aMaxIndex = A.length - 1;
		// B의 가장 큰 숫자의 인덱스
		int bMaxIndex = B.length - 1;
		// B의 가장 작은 숫자의 인덱스
		int bMinIndex = 0;

		while (true) {
			// A팀 인원이 다 출전했으면 멈춤
			if (aMaxIndex < 0) {
				break;
			}
			// A의 가장 큰 숫자가 B의 가장 큰 숫자와 같거나 크다면 B의 큰 숫자를 아끼기위해 제일 작은 숫자와 승부를 보게해 진다
			if (A[aMaxIndex] >= B[bMaxIndex]) {
				aMaxIndex--;
				bMinIndex++;
			}
			// A의 가장 큰 숫자보다 B의 가장 큰 숫자가 크다면 승리한다
			else {
				aMaxIndex--;
				bMaxIndex--;
				answer++;
			}
		}

		return answer;
	}
}

package programmers.level3;

import java.util.HashSet;

// Programmers_N으로표현_level3
public class Programmers_N으로표현 {
	public static void main(String[] args) {
		int N = 5;
		int number = 26;
		System.out.println(solution(N, number));
	}

	public static int solution(int N, int number) {
		// N을 1~8개 사용했을 때의 모든 숫자를 저장할  set
		HashSet<Integer>[] numberSet = new HashSet[9];
		// N, NN, NNN, ...을 만들기 위한 변수
		int num = N;
		// 1~8의 hashset을 초기화하고, 초기값을 넣어줌
		for (int i = 1; i < 9; i++) {
			numberSet[i] = new HashSet<Integer>();
			numberSet[i].add(num);
			num = num * 10 + N;
		}
		// N을 1~8번 사용했을 때
		for (int i = 1; i < 9; i++) {
			// N을 1~8번 사용한 것과 1~i번 사용한 것을 연산했을 때
			for (int j = 1; j < i; j++) {
				// j번 사용
				for (int num1 : numberSet[j]) {
					// num1+num2에 사용된 N의 개수가 i이어야 하므로 i-j번째에 있는 수
					for (int num2 : numberSet[i - j]) {
						numberSet[i].add(num1 + num2);
						numberSet[i].add(num1 - num2);
						numberSet[i].add(num1 * num2);
						// 나눗셈에서 나누는 숫자가 0이 될 수 없다
						if (num2 != 0) {
							numberSet[i].add(num1 / num2);
						}
					}
				}
			}
		}
		int answer = -1;
		// 최솟값을 찾는 것이므로 1부터
		for (int i = 1; i < numberSet.length; i++) {
			// 해당하는 숫자가 있으면 N을 i번 사용한 것
			if (numberSet[i].contains(number)) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	/**
	 * 문제는 통과했지만, 26 = 5*5+(5/5) => 4인데 내가 짠 코드는 괄호 우선 연산이 들어가지못해 해당 경우를 30/5로
	 * 계산해버리기 때문에 코드를 돌렸을 때 최솟값은 (5*5*5+5)/5가 나온다
	 */

//	static int min;
//
//	public static int solution(int N, int number) {
//		// 최소값을 저장할 변수
//		min = 9;
//		// N 사용 횟수의 최솟값을 찾음
//		find(0, 0, N, number);
//		// min이 9이상이면 -1을 반환
//		return min > 8 ? -1 : min;
//	}
//
//	private static void find(int sum, int cnt, int N, int number) {
//		// cnt가 9이상이면 더 갈 필요가 없다
//		if (cnt > 8) {
//			return;
//		}
//		// 찾는 숫자와 계산 값이 같으면 최솟값인지 비교하고 저장
//		if (sum == number) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		// N부터 넣어보고 NN, NNN, ...으로 계산을 시도
//		int num = N;
//		for (int i = 1; i < 9; i++) {
//			// 더하기
//			find(sum + num, cnt + i, N, number);
//			// 빼기
//			find(sum - num, cnt + i, N, number);
//			// 나누기
//			find(sum / num, cnt + i, N, number);
//			// 곱하기
//			find(sum * num, cnt + i, N, number);
//			// num을 다음 자리 숫자로 만듬
//			num = num * 10 + N;
//		}
//	}
}

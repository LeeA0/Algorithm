package programmers.level1;

import java.util.Arrays;

// Programmers_자연수뒤집어배열로만들기_level1
public class Programmers_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(long n) {
		// 숫자를 저장할 배열 선언
		// 배열의 크기는 숫자의 길이만큼
		int[] answer = new int[Long.toString(n).length()];
		// n이 0보다 작을 때까지 나눠야 모든 자릿수를 볼 수 있음
		for (int i = 0; n > 0; i++) {
			// 나머지 연산을 이용해 작은 자릿수 숫자부터 저장한다
			answer[i] = (int) (n % 10);
			n /= 10;
		}
		return answer;
	}
}

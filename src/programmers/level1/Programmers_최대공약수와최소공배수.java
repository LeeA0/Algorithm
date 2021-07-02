package programmers.level1;

import java.util.Arrays;

// Programmers_최대공약수와최소공배수_level1
public class Programmers_최대공약수와최소공배수 {
	public static void main(String[] args) {
		int n = 2;
		int m = 5;
		System.out.println(Arrays.toString(solution(n, m)));
	}

	public static int[] solution(int n, int m) {
		// 최대공약수와 최소공배수를 저장할 배열
		int[] answer = new int[2];
		int l, s;
		// 큰 숫자를 l, 작은 숫자를 s에 저장한다
		if (n > m) {
			l = n;
			s = m;
		} else {
			l = m;
			s = n;
		}
		// 유클리드 호제법을 이용해 최대공약수를 구한다
		// 재귀로도 변경가능
		while (s > 0) {
			l = l % s;
			int temp = l;
			l = s;
			s = temp;
		}
		// 최대공약수
		answer[0] = l;
		// 최소공배수
		answer[1] = n * m / answer[0];
		return answer;
	}
}

package programmers.level1;

import java.util.Arrays;

// Programmers_x만큼간격이있는n개의숫자_level1
public class Programmers_x만큼간격이있는n개의숫자 {
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		System.out.println(Arrays.toString(solution(x, n)));
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		long a = 0;
		for (int i = 0; i < n; i++) {
			a += x;
			answer[i] = a;
		}
		return answer;
	}
}

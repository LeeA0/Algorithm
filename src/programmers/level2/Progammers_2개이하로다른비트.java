package programmers.level2;

import java.util.Arrays;

// Progammers_2개이하로다른비트_level2
public class Progammers_2개이하로다른비트 {
	public static void main(String[] args) {
		long[] numbers = { 2, 7, 13, 15 };
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	// 시간 초과로 실패
	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			long curr = numbers[i];
			if (curr % 2 == 0) {
				answer[i] = curr + 1;
			} else {
				int idx = 0;
				while (true) {
					if (((1 << idx) & curr) == 0) {
						answer[i] = curr + (1 << (idx - 1));
						break;
					}
					idx++;
				}
			}
		}
		return answer;
	}
}

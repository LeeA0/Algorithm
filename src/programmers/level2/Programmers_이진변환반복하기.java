package programmers.level2;

import java.util.Arrays;

// Programmers_이진변환반복하기_level2
public class Programmers_이진변환반복하기 {
	public static void main(String[] args) {
		String s = "110010101001";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		// 이진변환 횟수와 제거된 0의 개수를 저장할 배열
		int[] answer = new int[2];
		// s가 "1"이 될 때까지 반복
		while (!s.equals("1")) {
			// 남은 1의 개수를 세기 위한 변수
			int length = 0;
			// 문자열 조회
			for (int i = 0; i < s.length(); i++) {
				// 0이면 0의 개수 +1
				if (s.charAt(i) == '0') {
					answer[1]++;
				}
				// 1이면 길이 +1
				else {
					length++;
				}
			}
			// 1의 개수를 이진수로 변환해 s에 저장
			s = Integer.toBinaryString(length);
			// 이진변환을 한 번 수행했으므로 +1
			answer[0]++;
		}
		return answer;
	}
}

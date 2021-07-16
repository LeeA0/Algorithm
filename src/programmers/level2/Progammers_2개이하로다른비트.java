package programmers.level2;

import java.util.Arrays;

// Progammers_2개이하로다른비트_level2
public class Progammers_2개이하로다른비트 {
	public static void main(String[] args) {
		long[] numbers = { 2, 7, 13, 15 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static long[] solution(long[] numbers) {
		// 정답을 저장하는 배열
		long[] answer = new long[numbers.length];
		// 전체 숫자의 2개이하로 다른 비트를 찾음
		for (int i = 0; i < numbers.length; i++) {
			// 현재 숫자
			long curr = numbers[i];
			// 2개이하로 다른 비트는 가장 작은 0을 찾아서 1로 바꿔주어야함
			// 짝수일 경우 1010 => 1011이 되야하므로 1만 더하면 됨
			if (curr % 2 == 0) {
				answer[i] = curr + 1;
			}
			// 홀수일 경우
			else {
				// 0을 빠르게 찾기위해 문자열로 변환
				String binary = Long.toBinaryString(curr);
				long last_zero_idx;
				// "1011"과 같이 0을 중간에 포함하고 있으면
				if (binary.contains("0")) {
					// "0"의 인덱스는 왼쪽기준으로 세기떄문에 오른쪽을 기준으로 하기위해 총 길이에서 뺌
					last_zero_idx = binary.length() - (binary.lastIndexOf("0") + 1);
				} 
				// "111"과 같이 0이 중간에 없으면
				else {
					//  "0111"처럼 총 길이 번째에 있는 게 0임
					last_zero_idx = binary.length();
				}
				// 여기서 1옆에 l을 안 붙여서 1시간이나 해맸다 ㅠㅠㅠ! 꼭 자료형 확인하기!!
				// "1011"에서 오른쪽을 기준으로 0바로 옆에 있는 1에 1을 더하면 "01"=>"10"이 됨
				answer[i] = curr + (1l << (last_zero_idx - 1));
			}
		}
		return answer;
	}
}

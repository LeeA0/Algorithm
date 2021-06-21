package programmers;

// Programmers_다트게임_level1
public class Programmers_다트게임 {
	public static void main(String[] args) {
		String dartResult = "1T2D3D#";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		// 점수를 저장할 배열 선언
		int[] score = new int[3];
		// 최근 점수가 저장된 곳의 인덱스
		int idx = -1;
		// 문자열을 순서대로 읽는다
		for (int i = 0; i < dartResult.length(); i++) {
			// 문자가 숫자면
			if (Character.isDigit(dartResult.charAt(i))) {
				// 인덱스를 증가하고
				idx++;
				// 점수를 num에 임시로 저장한다
				int num = dartResult.charAt(i) - '0';
				// 다음 문자를 읽기위해 인덱스 +1
				i++;
				// 다음 문자가 숫자면 10이다
				if (Character.isDigit(dartResult.charAt(i))) {
					num *= 10;
					i++;
				}
				// 보너스 점수를 계산한다
				switch (dartResult.charAt(i)) {
				case 'S':
					score[idx] = num;
					break;
				case 'D':
					score[idx] = num * num;
					break;
				case 'T':
					score[idx] = num * num * num;
					break;
				}
			} 
			// 아니면 히든 점수 획득
			else {
				switch (dartResult.charAt(i)) {
				case '*':
					// 현재 점수에 2배
					score[idx] *= 2;
					// 인덱스가 0이 아니면 전 점수에도 2배
					if (idx != 0) {
						score[idx - 1] *= 2;
					}
					break;
				case '#':
					score[idx] *= -1;
					break;
				}
			}
		}
		// 점수를 전부 더해 반환한다
		int answer = 0;
		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
		return answer;
	}
}

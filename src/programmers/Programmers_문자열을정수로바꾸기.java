package programmers;

// Programmers_문자열을정수로바꾸기_level1
public class Programmers_문자열을정수로바꾸기 {
	public static void main(String[] args) {
		String s = "1234";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		// 문자열을 정수로 변경
		// return Integer.parseInt(s);
		
		// 직접 구현
		// 정답을 저장할 변수
		int answer = 0;
		// 문자열을 문자 배열로 변환
		char[] number = s.toCharArray();
		// 음수인지 여부
		boolean sign = false;
		// 음수면 flag true
		if (number[0] == '-') {
			sign = true;
		} 
		// 양수면 패스 ~
		else if (number[0] == '+') {
		}
		// -도 +도 아니면 숫자로 시작하므로 숫자를 입력
		else {
			answer = number[0] - '0';
		}
		// 차례차례읽으면서 문자를 숫자로 변환
		for (int i = 1; i < number.length; i++) {
			answer = answer * 10 + (number[i] - '0');
		}
		// 음수면 -1을 곱해준다
		return sign ? answer * -1 : answer;
	}
}

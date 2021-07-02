package programmers.level1;

// Programmers_이상한문자만들기_level1
public class Programmers_이상한문자만들기 {
	public static void main(String[] args) {
		String s = "try hello world";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		// 문자열을 문자배열로 변경
		char[] c = s.toCharArray();
		// 단어의 문자가 몇번째 문자인지 세기위한 변수
		int idx = 0;
		// 전체 문자배열을 탐색
		for (int i = 0; i < c.length; i++) {
			// 공백이면 인덱스를 초기화
			if (c[i] == ' ') {
				idx = 0;
			}
			// 아니면
			else {
				// 짝수일 때는 대문자
				if (idx % 2 == 0) {
					c[i] = Character.toUpperCase(c[i]);
				}
				// 홀수일 때는 소문자
				else {
					c[i] = Character.toLowerCase(c[i]);
				}
				// 다음 문자의 인덱스를 세기위해 1을 더해준다
				idx++;
			}
		}
		return new String(c);
	}
}

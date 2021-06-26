package programmers.level2;

// Programmers_JadenCase문자열만들기_level2
public class Programmers_JadenCase문자열만들기 {
	public static void main(String[] args) {
		String s = "3people  unFollowed me";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		// 정답을 저장할 StringBuilder
		// 문자를 그냥 더하는 것보다 메모리의 낭비를 줄여줌
		StringBuilder answer = new StringBuilder();
		// 맨 앞의 문자를 제외하고 나머지는 소문자이므로 전체를 소문자로 바꾼 후 시작
		s = s.toLowerCase();
		// 맨 첫문자인지 확인하기위한 용도
		int idx = 0;
		// 전체 문자 조회
		for (int i = 0; i < s.length(); i++) {
			// 문자가 알파벳이고, 첫문자면 대문자로 변경해서 저장
			if (Character.isAlphabetic(s.charAt(i)) && idx == 0) {
				answer.append(Character.toUpperCase(s.charAt(i)));
			} 
			// 아니면
			else {
				// 만약 공백이면 idx 초기화
				if (s.charAt(i) == ' ') {
					idx = -1;
				}
				// 그대로 저장
				answer.append(s.charAt(i));
			}
			// 인덱스 증가
			idx++;
		}
		return answer.toString();
	}
}

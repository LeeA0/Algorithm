package programmers.level1;

import java.util.Arrays;

// Programmers_문자열내림차순으로배치하기_level1
public class Programmers_문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		// 문자열을 문자 배열로 변환
		char[] c = s.toCharArray();
		// 오름차순 정렬
		Arrays.sort(c);
		// 역순으로 정렬하기위해 Stringbuilder에 넣음
		StringBuilder sb = new StringBuilder(new String(c));
		// 역순으로 반환
		return sb.reverse().toString();
		// 참고용
//		return Stream.of(str.split(""))
//	    .sorted(Comparator.reverseOrder())
//	    .collect(Collectors.joining());
	}
}

package programmers;

import java.util.Arrays;

// Programmers_정수내림차순으로배치하기_level1
public class Programmers_정수내림차순으로배치하기 {
	public static void main(String[] args) {
		long n = 118372;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		// long을 문자배열로 변경
		char[] c = Long.toString(n).toCharArray();
		// 오름차순 정렬
		Arrays.sort(c);
		// 내림차순 정렬을 위해 Stringbuilder를 이용해 역정렬하고 그걸 string으로 변환 후 long으로 변환
		return Long.parseLong(new StringBuilder(new String(c)).reverse().toString());
	}
}

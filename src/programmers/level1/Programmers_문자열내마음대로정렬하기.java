package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

// Programmers_문자열내마음대로정렬하기_level1
public class Programmers_문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] strings = { "abce", "abcd", "cdx" };
		int n = 2;
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	public static String[] solution(String[] strings, int n) {
		// 문자를 조건에 맞게 정렬한다
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// n번째 문자가 같으면 문자열 순서대로 정렬
				if(o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}
				// 아니면 n번째 문자를 기준으로 정렬
				return Character.compare(o1.charAt(n), o2.charAt(n));
			}
		});
		return strings;
	}
}

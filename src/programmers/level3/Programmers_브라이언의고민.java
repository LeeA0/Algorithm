package programmers.level3;

import java.util.HashMap;

public class Programmers_브라이언의고민 {
	public static void main(String[] args) {
		String sentence = "AbAaAbAaC";
		System.out.println(solution(sentence));
	}
	// 장장 4일만에 풀었다 ..ㅠㅠ 조건이 너무 까다로웠음
	// aAa -> 규칙2
	// AaA -> 규칙1
	// AAAAaAaA = AAAA A A -> 규칙X + 규칙2 + 규칙X | 규칙X + 규칙1
	// AaAaAaACbBBBBb = AAAA C BBBB -> 규칙1 + 규칙X + 규칙2
	// AAAAaAa = AAAA A -> 규칙X + 규칙2
	// aAbBbAa = ABA -> 규칙2(규칙1)
	// aaA -> invalid
	// Aaa -> invalid
	// abAba -> invalid(규칙2 중복)
	// A A -> invalid(공백)
	// AbAaAbAaC -> invalid(기호 중복 사용)

	// 사용한 특수문자(소문자) 개수
	static HashMap<Character, Integer> usedSpecialChar;
	// 해당 특수문자가 이미 광고에 사용됬는지 여부
	static boolean[] isUsed;

	public static String solution(String sentence) {
		// 문자에 공백을 포함하고 있으면 invalid
		if (sentence.contains(" ")) {
			return "invalid";
		}

		// 사용된 특수문자의 개수를 셈
		usedSpecialChar = new HashMap<Character, Integer>();
		for (int i = 0; i < sentence.length(); i++) {
			char curr = sentence.charAt(i);
			if (Character.isLowerCase(curr)) {
				usedSpecialChar.put(curr, usedSpecialChar.getOrDefault(curr, 0) + 1);
			}
		}

		// 사용 여부
		isUsed = new boolean[26];

		// 문자 분리
		String original = seperate(sentence, false);

		// original이 비어있으면 invalid 아니면 유효한 광고문자
		return original.equals("") ? "invalid" : original;
	}

	// 문자를 분리해서 규칙1 혹은 규칙2를 이용해 original 문자로 변형
	public static String seperate(String sentence, boolean twice) {
		StringBuilder originalSb = new StringBuilder();
		// 자르는 문자의 시작 지점
		int idx = 0;
		for (int i = 0; i < sentence.length(); i++) {
			char curr = sentence.charAt(i);
			// 특수문자를 발견
			if (Character.isLowerCase(curr)) {
				// 이미 사용되었던 특수문자면 invalid
				if (isUsed[curr - 'a']) {
					return "";
				}
				// 사용하지 않았다면 사용처리
				isUsed[curr - 'a'] = true;
				// 해당 특수문자의 개수를 가져옴
				int num = usedSpecialChar.get(curr);
				// 현재 위치에서 특수문자의 개수까지 이동
				int cnt = 0;
				// 해당 특수문자의 마지막 위치
				int endIdx = i;
				// 해당 특수문자의 마지막 위치를 찾음
				for (int j = i; j < sentence.length(); j++) {
					// 해당 특수문자면 카운트
					if (curr == sentence.charAt(j)) {
						cnt++;
					}
					// 마지막 해당 특수문자를 찾으면 위치를 저장
					if (cnt == num) {
						endIdx = j;
						break;
					}
				}
				// 광고문자를 변환한 문자
				String original = "";
				// 특수문자의 개수가 2개고, 규칙2를 이미 한 번 사용하지 않았다면 규칙2
				if (num == 2 && !twice) {
					// 소문자 뒤에 저장하지않은 대문자가 있다면 저장
					if (idx != i) {
						originalSb.append(sentence.substring(idx, i)).append(" ");
						// 자르는 문자의 시작 지점을 이동
						idx = i;
					}
					// 자르는 문자의 끝 지점을 동기화
					i = endIdx;
					// 규칙 2에 맞게 변환
					// substring의 끝 인덱스는 자르려는 문자의 인덱스보다 1 커야함
					original = secondRule(sentence.substring(idx, i + 1));
					
					// original이 ""이면 규칙2의 조건에 맞지않는 것
					if (original.equals("")) {
						// 길이가 3이상이면 한 번 더 쪼개서 시도해본다
						// 이미 규칙2를 한 번 사용했으므로 true
						if (sentence.length() >= 3) {
							original = seperate(sentence.substring(idx + 1, i), true);
						}
						// 쪼갰는데도 ""면 invalid
						if (original.equals("")) {
							return "";
						}
					}
				}
				// 특수문자의 개수가 1또는 3이상이고, 규칙2를 이미 한 번 사용했다면(ex bAaAaAb) 규칙1
				else {
					// 규칙1은 대문자사이에 특수문자가 들어가므로 한 단계전까지 저장되지않은 대문자가 있는지 확인 후 저장
					if (idx < i - 1) {
						originalSb.append(sentence.substring(idx, i - 1)).append(" ");
						// 자르는 문자의 시작 지점을 이동
						idx = i - 1;
					}
					// 자르는 문자의 끝 지점을 동기화
					i = endIdx;
					// substring의 끝 인덱스는 자르려는 문자의 인덱스보다 1 커야함
					// 특수문자 뒤에 대문자가 하나 더 있어야 규칙1이 성립하므로 1더 큼
					// i+2가 sentence의 길이를 벗어나면 특수문자 뒤에 문자가 없다는 의미이므로 invalid
					if (i + 2 > sentence.length()) {
						return "";
					}
					// 규직 1에 맞게 변환
					original = firstRule(sentence.substring(idx, i + 2), curr);
					// original이 ""이면 invalid
					if (original.equals("")) {
						return "";
					}
					// 뒤의 문자까지 변환했으므로 i를 1증가
					i++;
				}
				// 변환된 문자를 저장
				originalSb.append(original).append(" ");
				// 앞으로 자를 부분을 이미 자른 부분의 앞으로 이동
				idx = i + 1;
			}
		}
		// 마지막으로 남은 대문자가 있다면 추가
		originalSb.append(sentence.substring(idx, sentence.length()));
		// 양 옆의 공백을 제거
		return originalSb.toString().trim();
	}

	// sentence를 규칙2에 맞게 변환
	public static String secondRule(String sentence) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < sentence.length() - 1; i++) {
			char curr = sentence.charAt(i);
			// 특수문자 안에 소문자가 있으면 안 됨
			if (Character.isLowerCase(curr)) {
				return "";
			}
			sb.append(curr);
		}
		return sb.toString();
	}

	// sentence를 규칙1에 맞게 변환
	public static String firstRule(String sentence, char specialChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sentence.length(); i++) {
			char curr = sentence.charAt(i);
			// 짝수번째인데 소문자면 안 됨
			if (i % 2 == 0 && Character.isLowerCase(curr)) {
				return "";
			}
			// 홀수번째인데 대문자이거나 해당 특수문자와 다른 특수문자가 있으면 안 됨
			if (i % 2 == 1 && (Character.isUpperCase(curr) || curr != specialChar)) {
				return "";
			}
			// 대문자면 저장
			if (Character.isUpperCase(curr)) {
				sb.append(curr);
			}
		}
		return sb.toString();
	}
}

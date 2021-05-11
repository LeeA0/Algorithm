package programmers;

import java.util.HashMap;

public class Programmers_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		// 대소문자 상관없으므로 전부 소문자로 치환
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// str1을 두 글자씩 나눠 개수를 저장하는 해쉬 맵 (나중에 교집합, 합집합을 구하기위해 개수를 셈)
		HashMap<String, Integer> strMap1 = new HashMap<>();
		// str2을 두 글자씩 나눠 개수를 저장하는 해쉬 맵
		HashMap<String, Integer> strMap2 = new HashMap<>();
		for (int i = 0; i < str1.length() - 1; i++) {
			String sum = "" + str1.charAt(i) + str1.charAt(i + 1);
			// 두 글자 전부 알파벳소문자일 경우(앞에서 전부 치환했으므로 대문자가 나올일은 없다)
			if (Character.isLowerCase(str1.charAt(i)) && Character.isLowerCase(str1.charAt(i + 1))) {
				strMap1.put(sum, strMap1.getOrDefault(sum, 0) + 1);
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			String sum = "" + str2.charAt(i) + str2.charAt(i + 1);
			// 두 글자 전부 알파벳소문자일 경우(앞에서 전부 치환했으므로 대문자가 나올일은 없다)
			if (Character.isLowerCase(str2.charAt(i)) && Character.isLowerCase(str2.charAt(i + 1))) {
				strMap2.put(sum, strMap2.getOrDefault(sum, 0) + 1);
			}
		}

		// 교집합의 개수
		int intersection = 0;
		// 합집합의 개수
		int union = 0;
		HashMap<String, Integer> unionMap = new HashMap<>();
		for (String key : strMap1.keySet()) {
			// strMap1과 strMap2가 겹치는게 있을 때
			if (strMap2.get(key) != null) {
				// 교집합은 작은 숫자를 더함
				// 교집합의 경우 strMap2까지 볼 필요없으므로 바로 개수를 세준다
				intersection += Math.min(strMap1.get(key), strMap2.get(key));
				// 합집합은 큰 숫자를 저장
				unionMap.put(key, Math.max(strMap1.get(key), strMap2.get(key)));
			} 
			// 겹치는게 없으면
			else {
				// 합집합에 저장
				unionMap.put(key, strMap1.get(key));
			}
		}

		for (String key : strMap2.keySet()) {
			// strMap1과 겹치지않는 경우 합집합에 저장
			if (unionMap.get(key) == null) {
				unionMap.put(key, strMap2.get(key));
			}
		}

		// 합집합의 개수 세기
		for (String key : unionMap.keySet()) {
			union += unionMap.get(key);
		}

		// 합집합이 0인 경우 나눗셈에 의미가 없으므로 1로 친다
		// 여기에 65536을 곱하므로 답은 65536
		if (union == 0) {
			return 65536;
		}

		// integer의 경우 나누면 0이 되므로 곱셈을 먼저해준다
		return 65536 * intersection / union;
	}
}

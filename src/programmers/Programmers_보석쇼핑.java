package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Programmers_보석쇼핑 {

	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(Arrays.toString(solution(gems)));
	}

	public static int[] solution(String[] gems) {
		int[] answer = {};
		int min_length = 100000;

		int r = 0;
		int l = 0;

		// 개수 세기
		TreeSet<String> gem = new TreeSet<>();
		for (int i = 0; i < gems.length; i++) {
			gem.add(gems[i]);
		}

		// 범위 내의 보석의 개수를 센다
		// 슬라이드 윈도우 방식 사용예정
		HashMap<String, Integer> countGem = new HashMap<>();
		// 맨 첫번째 칸의 보석을 넣어준다
		countGem.put(gems[0], 1);

		while (true) {
			// 현재 범위의 보석종류가 전체 보석종류와 같으면
			if (gem.size() == countGem.size()) {
				// 길이가 가장 작은 길이보다 적으면 업데이트
				if (min_length > r - l + 1) {
					min_length = r - l + 1;
					answer = new int[] { l + 1, r + 1 };
				}
				// l을 증가시켜 범위를 줄여서 비교해볼 예정
				// l을 증가시키면 이전에 포함되어있던 보석을 제거해야한다
				// 만약 gem이 1이면 -1하면 0이 되므로 보석리스트에서 제거
				if (countGem.get(gems[l]) == 1) {
					countGem.remove(gems[l]);
				}
				// 아니면 -1
				else {
					countGem.put(gems[l], countGem.get(gems[l]) - 1);
				}
				// l을 증가
				l++;
				// l이 끝까지 가면 끝난다
				if (l >= gems.length) {
					break;
				}
			}
			// 다르면
			else {
				// r을 증가해서 범위를 넓힌다
				r++;
				// r이 끝까지 가면 끝난다
				if (r >= gems.length) {
					break;
				}
				// 리스트에 있던 보석이면 기존+1, 아니면 새로 추가 해준다
				countGem.put(gems[r], countGem.getOrDefault(gems[r], 0) + 1);
			}
		}

		return answer;
	}

//	// 시간초과
//	public static int[] solution(String[] gems) {
//		int[] answer = {};
//		int min_length = 100000;
//
//		HashMap<String, Boolean> includeGem = new HashMap<>();
//
//		// 종류 세기
//		for (int i = 0; i < gems.length; i++) {
//			includeGem.put(gems[i], false);
//		}
//
//		for (int i = 0; i < gems.length; i++) {
//			int contain = 0;
//			initial(includeGem);
//			for (int j = i; j < gems.length; j++) {
//				if (j - i >= min_length) {
//					break;
//				}
//				if (!includeGem.get(gems[j])) {
//					includeGem.put(gems[j], true);
//					contain++;
//				}
//				if (contain == includeGem.size()) {
//					min_length = j - i;
//					answer = new int[] { i + 1, j + 1 };
//					break;
//				}
//			}
//		}
//
//		return answer;
//	}
//
//	public static void initial(HashMap<String, Boolean> includeGem) {
//		for (String k : includeGem.keySet()) {
//			includeGem.put(k, false);
//		}
//	}
}

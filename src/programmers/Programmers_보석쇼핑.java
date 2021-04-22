package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Programmers_보석쇼핑 {

	public static void main(String[] args) {
		String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
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
		HashMap<String, Integer> countGem = new HashMap<>();

		while (l < gems.length && r < gems.length) {
			if (gem.size() == countGem.size()) {
				l++;
			} else {
				r++;
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

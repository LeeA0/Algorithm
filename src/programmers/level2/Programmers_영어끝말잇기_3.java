package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

// Programmers_영어끝말잇기_level2
// using hashmap
// 속도 : 상황마다 다르지만 평균적으로 for문,hashset보다 hashmap이 빠름
public class Programmers_영어끝말잇기_3 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			if (i != 0) {
				String forward = words[i - 1];
				String current = words[i];
				if (forward.charAt(forward.length() - 1) != current.charAt(0) || wordMap.get(words[i]) != null) {
					answer[0] = i % n + 1;
					answer[1] = i / n + 1;
					break;
				}
			}
			wordMap.put(words[i], 0);
		}
		return answer;
	}
}

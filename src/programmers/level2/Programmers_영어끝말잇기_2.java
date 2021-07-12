package programmers.level2;

import java.util.Arrays;
import java.util.TreeSet;

// Programmers_영어끝말잇기_level2
// using hashset
// 속도 : for문보다 hashset이 빠름
public class Programmers_영어끝말잇기_2 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };
		TreeSet<String> wordSet = new TreeSet<String>();
		for (int i = 0; i < words.length; i++) {
			wordSet.add(words[i]);
			if (i != 0) {
				String forward = words[i - 1];
				String current = words[i];
				if (forward.charAt(forward.length() - 1) != current.charAt(0) || wordSet.size() != i + 1) {
					answer[0] = i % n + 1;
					answer[1] = i / n + 1;
					break;
				}
			}
		}
		return answer;
	}
}

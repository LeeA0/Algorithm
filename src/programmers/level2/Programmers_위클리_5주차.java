package programmers.level2;

import java.util.ArrayList;
import java.util.TreeSet;

public class Programmers_위클리_5주차 {
	public static void main(String[] args) {
		String word = "AAAAE";
		System.out.println(solution(word));
	}

	static char[] words = { 'A', 'E', 'I', 'O', 'U' };

	public static int solution(String word) {
		TreeSet<String> dictionary = new TreeSet<String>();
		// 단어의 길이가 1~5까지인 모든 경우의 수를 구함
		for (int i = 1; i <= 5; i++) {
			// 중복순열
			repetitionPermutation(0, new char[i], i, dictionary);
		}
		ArrayList<String> dictionaryForFindByIdx = new ArrayList<>(dictionary);
		return dictionaryForFindByIdx.indexOf(word) + 1;
	}

	private static void repetitionPermutation(int cnt, char[] selectWord, int R, TreeSet<String> dictionary) {
		// R만큼 뽑았으면 사전에 추가하고 끝냄
		if (cnt == R) {
			dictionary.add(new String(selectWord));
			return;
		}
		for (int i = 0; i < words.length; i++) {
			// 단어 한 개 선택
			selectWord[cnt] = words[i];
			// 다음 단어 선택
			repetitionPermutation(cnt + 1, selectWord, R, dictionary);
		}
	}
}

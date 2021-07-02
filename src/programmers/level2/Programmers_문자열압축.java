package programmers.level2;

import java.util.ArrayList;

// 시간 줄이겠다고 이분탐색을 썼는데... 이분 탐색에 맞지 않는 경우의 수가 있었다
// 길이를 빠르게 재는게 관건이었던 문제같다
// Programmers_문자열압축_level2
public class Programmers_문자열압축 {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		// 최대 원본 문자열의 길이이므로 원본 문자열의 길이로 초기화
		int answer = s.length();

		// 원본 문자열의 길이부터 1씩 줄여가며 압축해본다
		for (int i = s.length(); i > 0; i--) {
			// 최소한의 가지치기
			// 만약 i의 길이로 잘랐을 때 나올 수 있는 최소 길이 
			// -> (개수+[i로 자른 문자열]+남은 문자)의 길이가 answer보다 작으면 압축해볼만 하다 판단
			if (answer > (i + 1 + s.length() % i)) {
				// 압축한 길이가 answer보다 작은지 판단하여 작으면 answer에 넣음
				answer = Math.min(answer, getLength(i, s));
			}
		}

		// 최소길이 answer 리턴
		return answer;
	}

	// 단어와 길이를 갖는 클래스
	public static class Word {
		String word;
		int num;

		public Word(String word, int num) {
			super();
			this.word = word;
			this.num = num;
		}
	}

	// 압축했을 때의 길이
	public static int getLength(int mid, String s) {
		// s를 char배열로 변환
		char[] c = s.toCharArray();
		// 문자를 저장할 StringBuilder선언
		StringBuilder sb = new StringBuilder();
		// 쪼개진 단어를 저장하는 리스트
		ArrayList<Word> words = new ArrayList<>();
		// 0부터 c배열을 순회할 인덱스
		int idx = 0;
		// idx가 c배열의 범위를 벗어나지않은 동안 반복
		while (idx < s.length()) {
			// StringBuilder에 해당 문자를 넣음
			sb.append(c[idx]);
			// 만약 일정 길이 이상 넣었으면
			if (idx % mid == mid - 1) {
				// words리스트가 비어있지않고,이전 단어와 현재 단어가 같으면
				if (!words.isEmpty() && words.get(words.size() - 1).word.equals(sb.toString())) {
					// 개수를 +1
					words.get(words.size() - 1).num++;
				} 
				// 다르면 새로 추가
				else {
					words.add(new Word(sb.toString(), 1));
				}
				// 추가한 후 StringBuilder 초기화
				sb.delete(0, sb.length());
			}
			// 인덱스 증가
			idx++;
		}
		// StringBuilder가 비어있지않으면, 남은 문자들을 저장
		if (!sb.toString().equals("")) {
			words.add(new Word(sb.toString(), 1));
		}

		// 저장한 단어들을 압축한 형태로 변환
		sb = new StringBuilder();
		for (Word w : words) {
			if (w.num != 1) {
				sb.append(w.num);
			}
			sb.append(w.word);
		}
		
		// 압축한 단어의 길이를 반환
		return sb.toString().length();
	}
}

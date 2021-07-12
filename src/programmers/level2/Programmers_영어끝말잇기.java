package programmers.level2;

import java.util.Arrays;

// Programmers_영어끝말잇기_level2
// using for
public class Programmers_영어끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
		// 끝말잇기에 전원 성공하면 {0,0}을 반환해야하므로 {0,0}으로 초기화
		int[] answer = { 0, 0 };
		// 전체 문자를 조회
		for (int i = 0; i < words.length; i++) {
			// 끝말잇기 규칙에 맞지않아 실패하면 탈락한 사람의 번호와 그 사람이 자신의 몇번째 차례에 탈락한 건지 저장
			if (!success(i, words[i], words)) {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				break;
			}
		}
		return answer;
	}

	private static boolean success(int idx, String string, String[] words) {
		// 맨 첫번째 단어가 아니면
		if (idx != 0) {
			// 앞 단어
			String forward = words[idx - 1];
			// 현재 단어
			String current = words[idx];
			// 앞 단어의 끝 문자와 현재 단어의 시작 문자가 같지 않으면 false반환
			if (forward.charAt(forward.length() - 1) != current.charAt(0)) {
				return false;
			}
		}
		// 전체 단어를 조회해서 중복이면 false, 아니면 true반환
		for (int i = 0; i < idx; i++) {
			if (words[i].equals(string)) {
				return false;
			}
		}
		return true;
	}
}

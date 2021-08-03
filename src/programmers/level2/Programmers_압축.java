package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Programmers_압축_level2
public class Programmers_압축 {
	public static void main(String[] args) {
		String msg = "KAKAO";
		System.out.println(Arrays.toString(solution(msg)));
	}

	/*
	 * 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
	 * 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
	 * 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
	 * 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
	 * 5. 단계 2로 돌아간다.
	 * 
	 * => 아이디어
	 * 단어를 키값으로, 인덱스를 값으로 저장한 사전 hashmap을 하나 생성
	 * msg의 맨 처음 문자부터 사전에서 조회해서 있으면 다음 문자를 포함한 단어를 조회
	 * 있으면 반복, 없으면 현재 문자에서 맨마지막 문자를 뺀 단어의 인덱스를 정답리스트에 저장
	 * 새로생긴 단어를 사전에 인덱스와 함꼐 저장
	 */
	public static int[] solution(String msg) {
		// 정답을 저장할 리스트
		ArrayList<Integer> answerList = new ArrayList<Integer>();

		// 단어 사전
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		// 단어 사전의 인덱스
		int idx;
		// 1~26까지의 인덱스에 알파벳 대문자를 순서대로 넣음
		for (idx = 1; idx <= 26; idx++) {
			dictionary.put(Character.toString('A' + idx - 1), idx);
		}

		// 전체 문장 탐색
		for (int i = 0; i < msg.length(); i++) {
			// i번째 문자를 기준으로 덧붙여서 조회하기 위한 StringBuilder
			StringBuilder sb = new StringBuilder();
			// i번째 문자부터 문자의 끝까지 탐색
			for (int j = i; j < msg.length(); j++) {
				// j번째 문자 덧붙임
				sb.append(msg.charAt(j));
				// 만약 현재까지 만들어진 단어가 사전에 없는 단어면
				if (!dictionary.containsKey(sb.toString())) {
					// 현재 입력(w)의 인덱스 정답 배열에 저장
					answerList.add(dictionary.get(sb.substring(0, sb.length() - 1).toString()));
					// w+c 사전 추가
					dictionary.put(sb.toString(), idx++);
					// 현재 i는 사전에 등록되지않은 단어까지 조회했을 때의 인덱스이므로 사전에 등록된 문장까지의 인덱스로 표시하기위해 -1
					// ex)
					// 전체 문장 KAKAO
					// sb에 저장된 단어: KAK => i=2
					// 사전에 등록된 단어: KA => K부터 다음 단어를 조회해야하므로 i는 A의 인덱스인 1이어야함
					i--;
					break;
				}
				// 다음 단어 조회
				i++;
			}
			// 만약 모든 단어를 탐색했으면 마지막으로 저장된 단어의 인덱스를 정답리스트에 저장
			if (i == msg.length()) {
				answerList.add(dictionary.get(sb.toString()));
			}
		}

		// 리스트를 배열로 변환
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}
}

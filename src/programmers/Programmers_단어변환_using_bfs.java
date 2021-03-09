package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Programmers_단어변환_레벨3
public class Programmers_단어변환_using_bfs {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String begin = br.readLine();
		String target = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			words[i] = st.nextToken();
		}
		System.out.println(solution(begin, target, words));

	}
	
	// 현재 단어와 변환된 횟수를 저장하는 객체
	static class Word {
		// 현재 단어
		String word;
		// 변환된 횟수
		int cnt;

		public Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}

	static int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		// 각각의 단어를 방문했는 지 체크해주는 배열
		boolean[] visited = new boolean[words.length];

		// que를 사용했을 때 전체적으로 방문처리를 어떻게 해야할까 고민
		// -> 어처피 맨 먼저 목표지점에 도달하는 것이 가장 짧은 변환 횟수이므로, 경로 상관없이 전체적으로 visit체크
		Queue<Word> que = new LinkedList<Word>();
		// 맨 처음 글자를 Queue에 넣어줌
		que.offer(new Word(begin, 0));

		// Queue가 비어있지않은 동안 실행
		a: while (!que.isEmpty()) {
			// 현재 단어
			Word curr = que.poll();
			String cWord = curr.word;
			int cCnt = curr.cnt;
			// 전체 단어 리스트에서 변환가능한 단어 탐색
			for (int i = 0; i < words.length; i++) {
				// 이미 한 번 변환 헀던 단어는 다시 변환해도 의미가 없으므로 패스
				if (visited[i])
					continue;
				// 현재 단어의 글자가 비교 단어의 글자와 같은 것의 개수를 체크
				int cnt = 0;
				for (int j = 0; j < cWord.length(); j++) {
					// 현재 단어의 글자와 비교 단어의 글자가 위치가 같고, 단어가 같으면 +1
					if (cWord.charAt(j) == words[i].charAt(j)) {
						cnt++;
					}
				}
				// 현재 단어와 비교 단어의 글자 다른 것의 개수가 1개면
				if (cnt == cWord.length() - 1) {
					// 비교 단어와 목표 단어가 같으면
					if (target.equals(words[i])) {
						// 변환 횟수를 저장하고
						answer = cCnt + 1;
						// 반복을 멈춤
						break a;
					}
					// 비교 단어를 다음 단어로 넣어주고, 변환 횟수를 +1해준다
					que.offer(new Word(words[i], cCnt + 1));
					// 다음 단어를 방문처리 해준다
					visited[i] = true;
				}
			}
		}

		return answer;
	}
}

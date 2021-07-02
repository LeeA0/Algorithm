package programmers.level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers_단어변환_레벨3
public class Programmers_단어변환_using_dfs {
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

	static int answer;

	static int solution(String begin, String target, String[] words) {
		answer = Integer.MAX_VALUE;
		dfs(begin, -1, 0, new boolean[words.length], words, target);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	static void dfs(String word, int idx, int depth, boolean[] visited, String[] words, String target) {
		if (idx >= 0 && target.equals(word)) {
			answer = Math.min(answer, depth);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i])
				continue;
			int cnt = 0;
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) == words[i].charAt(j)) {
					cnt++;
				}
			}
			if (cnt == word.length() - 1) {
				visited[i] = true;
				dfs(words[i], i, depth + 1, visited, words, target);
				visited[i] = false;
			}
		}
	}
}

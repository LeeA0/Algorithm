package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 더 짧게 해보기
//SW_햄스터_8275_D4
public class Solution_8275_햄스터 {
	static class rule {
		int l;
		int r;
		int s;

		public rule(int l, int r, int s) {
			super();
			this.l = l;
			this.r = r;
			this.s = s;
		}
	}

	static int T, N, X, M;
	static int[] fence, answer;
	static rule[] rules;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			rules = new rule[M];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				rules[i] = new rule(l, r, s);
			}

			// 가능한 경우의 수를 임시 저장
			fence = new int[N];
			// 답을 저장
			answer = new int[N];
			Arrays.fill(answer, -1);
			dfs(N - 1);
			if (answer[0] == -1) {
				sb.append("#").append(t).append(" -1").append("\n");
			} else {
				sb.append("#").append(t).append(" ");
				for (int i = 0; i < answer.length; i++) {
					sb.append(answer[i]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	private static boolean dfs(int cnt) {
		if (cnt == -1) {
			boolean can = false;
			for (int i = 0; i < M; i++) {
				rule curr = rules[i];
				int sum = 0;
				for (int j = curr.l - 1; j <= curr.r - 1; j++) {
					sum += fence[j];
				}
				if (sum != curr.s) {
					return false;
				}
			}
			answer = fence;
			return true;
		}
		for (int i = X; i >= 0; i--) {
			fence[cnt] = i;
			if (dfs(cnt - 1)) {
				return true;
			}
		}
		return false;
	}
}

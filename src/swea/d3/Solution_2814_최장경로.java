package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_최장경로_2814_D3
public class Solution_2814_최장경로 {
	static int T, N, M, answer;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			adj = new boolean[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				adj[a][b] = true;
				adj[b][a] = true;
			}

			answer = 0;
			
			for (int i = 0; i < N; i++) {
				dfs(i, 1, new boolean[N]);
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int cur, int cnt, boolean[] visited) {
		visited[cur] = true;
		int temp_cnt = 0;
		for (int i = 0; i < N; i++) {
			if (adj[cur][i] && !visited[i]) {
				temp_cnt++;
				dfs(i, cnt + 1, visited);
			}
		}
		if (temp_cnt == 0) {
			answer = Math.max(answer, cnt);
		}
		visited[cur] = false;
	}
}

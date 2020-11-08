package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW_키순서_5643_D4
public class Solution_5643_키순서 {
	static int T, N, M, answer;
	static int[][] adjmatrix;
	static int[] cnt_small, cnt_big;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			adjmatrix = new int[N][N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjmatrix[from - 1][to - 1] = 1;
			}

			cnt_big = new int[N];
			cnt_small = new int[N];

			int answer = 0;
			// 순서대로 담색
			for (int i = 0; i < N; i++) {
				dfs(i, i, new boolean[N]);
			}
			// 정답 카운트
			for (int i = 0; i < N; i++) {
				if (cnt_big[i] + cnt_small[i] == N - 1) {
					answer++;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	// 처음 시작하는 것, 현재 방문 중인 것. 방문처리 배열
	private static void dfs(int start, int curr, boolean[] visited) {
		visited[curr] = true;
		for (int i = 0; i < N; i++) {
			// 현재 정점 중에서 방문할 수 있는 정점이 있을 때
			if (!visited[i] && adjmatrix[curr][i] == 1) {
				// 출발 정점 기준으로 큰게 하나 더 있다는 의미 이므로 +1
				cnt_big[start]++;
				// 다음 정점은 현재정점을 봄으로써 자신보다 작은게 하나 있으므로 +1
				cnt_small[i]++;
				// 다음 정점 방문
				dfs(start, i, visited);
			}
		}
	}
}

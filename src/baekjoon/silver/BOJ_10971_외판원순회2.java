package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_외판원순회2_10971_실버2
public class BOJ_10971_외판원순회2 {
	static int N, min_cost, cost, start;
	static int[][] W;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료

		min_cost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			cost = 0;
			visited = new boolean[N];
			visited[i] = true;
			start = i;
			dfs(i, 1);
		}
		System.out.println(min_cost);
	}

	static void dfs(int curr, int cnt) {
		if (cnt == N) {
			min_cost = Math.min(min_cost, cost + W[curr][start]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i] && W[i][curr] != 0) {
				cost += W[curr][i];
				visited[i] = true;
				dfs(i, cnt+1);
				cost -= W[curr][i];
				visited[i] = false;
			}
		}
	}
}

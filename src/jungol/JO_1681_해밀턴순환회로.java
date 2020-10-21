package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//싸이클이 있으므로 Prim 안 됨.
//dfs접근 필요
//정올_해밀턴 순환회로_1681
public class JO_1681_해밀턴순환회로 {
	// N : 정점의 개수, min : 최소비용
	static int N, min;
	// 인접행렬
	static int[][] adjmatrix;
	// 정점 방문여부
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		adjmatrix = new int[N][N];
		visited = new boolean[N];

		// 입력 받음
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				adjmatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		// 0부터 시작 -> cnt=1
		dfs(0, 0, 1);

		System.out.println(min);
	}

	public static void dfs(int node, int dist, int cnt) {
		if (dist > min) {
			return;
		}
		
		if (cnt == N) {
			//다시 0으로 가는 길이 있으면
			if (adjmatrix[node][0] != 0) {
				dist += adjmatrix[node][0];
				min = Math.min(min, dist);
			}
			return;
		}

		visited[node] = true;

		for (int i = 0; i < N; i++) {
			// 다음 노드로 이동
			if (!visited[i] && adjmatrix[node][i] != 0) {
				dfs(i, dist + adjmatrix[node][i], cnt + 1);
			}
		}
		visited[node] = false;
	}
}
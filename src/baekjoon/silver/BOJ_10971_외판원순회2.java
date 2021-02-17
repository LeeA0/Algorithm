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

		// 최소 비용을 저장하는 변수
		min_cost = Integer.MAX_VALUE;
		// 출발 도시: 0부터 N
		for (int i = 0; i < N; i++) {
			// 여행경로 한 번의 비용을 저장하는 변수
			cost = 0;
			// 방문한 도시를 체크하는 배열
			visited = new boolean[N];
			// 첫 도시 방문 표시
			visited[i] = true;
			// 첫 도시 저장
			start = i;
			// 이동
			dfs(i, 1);
		}
		System.out.println(min_cost);
	}
	
	// curr: 현재 방문 도시
	// cnt: 현재까지 방문한 도시 수
	static void dfs(int curr, int cnt) {
		// 모든 도시를 방문했으면
		if (cnt == N) {
			// 마지막 도시에서 처음 도시로 가는 경로가 있으면
			if (W[curr][start] != 0) {
				// 최소 비용 갱신
				min_cost = Math.min(min_cost, cost + W[curr][start]);
			}
			return;
		}
		// 0~N 중에 갈 수 있는 도시 탐색
		for (int i = 0; i < N; i++) {
			// 방문하지 않았고, 갈 수 있는 곳이면
			if (!visited[i] && W[curr][i] != 0) {
				// 다음 도시로 가는 비용 더함
				cost += W[curr][i];
				// 다음 도시 방문 처리
				visited[i] = true;
				// 다음 도시로 이동
				dfs(i, cnt + 1);
				// 되돌리기
				cost -= W[curr][i];
				visited[i] = false;
			}
		}
	}
}

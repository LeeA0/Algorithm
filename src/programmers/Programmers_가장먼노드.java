package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_가장먼노드 {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}

	public static int solution(int n, int[][] edge) {
		// 인접한 정점을 저장할 간선 리스트 배열을 생성
		ArrayList<Integer>[] adj = new ArrayList[n + 1];

		// 정점마다 인접할 정점을 저장할 리스트를 생성
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		// 인접한 정점을 양방향이므로 양쪽에 저장
		for (int i = 0; i < edge.length; i++) {
			adj[edge[i][0]].add(edge[i][1]);
			adj[edge[i][1]].add(edge[i][0]);
		}

		// bfs탐색을 통해 1과 가장 먼 노드의 개수를 구한다
		return bfs(1, n, adj);
	}

	public static int bfs(int start, int n, ArrayList<Integer>[] adj) {
		// 정점을 저장할 queue선언
		Queue<Integer> que = new LinkedList<Integer>();
		// 첫 시작점을 넣는다
		que.offer(start);
		// 방문여부를 체크할 visited배열 생성
		boolean[] visited = new boolean[n + 1];
		// 첫 시작점을 방문체크한다
		visited[start] = true;
		// 각 깊이별 노드의 개수를 저장할 변수 선언
		int size = 0;
		// queue가 비어있지 않은 동안 반복
		while (!que.isEmpty()) {
			// 각 깊이별 노드의 개수를 저장
			size = que.size();
			for (int i = 0; i < size; i++) {
				// 저장된 정점하나를 꺼낸다
				int curr = que.poll();
				// 해당 정점에서 갈 수 있는 모든 정점을 탐색한다
				for (int next : adj[curr]) {
					// 이미 방문한 적있는 정점은 또 방문하면 최단거리가 아니므로, 이미 방문한 적이 없으면 queue에 저장 및 방문 처리
					if (!visited[next]) {
						que.offer(next);
						visited[next] = true;
					}
				}
			}
		}
		return size;
	}
}

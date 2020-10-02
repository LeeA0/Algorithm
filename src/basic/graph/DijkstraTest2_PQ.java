package basic.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2_PQ {
	static class Vertex implements Comparable<Vertex> {
		// totalDistance : 출발지에서 자신까지 오는 최단거리
		int no, totalDistance;

		public Vertex(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// // totalDistance가 작은 비용이 우선적으로 처리
			return this.totalDistance - o.totalDistance;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine().trim());
		int start = 0;
		int end = V - 1;
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V];
		int[] distance = new int[V]; // 출발지에서 자신까지 오는 최단거리
		boolean[] visited = new boolean[V]; // 처리한 정점 여부 관리

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();

		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		pQueue.offer(new Vertex(start, distance[start]));

		int min = 0;
		Vertex current = null;

		while (!pQueue.isEmpty()) {

			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			current = pQueue.poll();
			// PQ에 남아있던 totalDistance의 최소비용보다 더 큰 상태
			if (visited[current.no])
				continue;

			visited[current.no] = true;
			if (current.no == end)
				break;

			// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			for (int j = 0; j < V; j++) {
				// min ==> distance[current]
				if (!visited[j] && matrix[current.no][j] != 0
						&& distance[j] > current.totalDistance + matrix[current.no][j]) {
					distance[j] = current.totalDistance + matrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		System.out.println(distance[end]);
	}
}

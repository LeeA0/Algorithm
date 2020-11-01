package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준_특정한최단경로_1504_골드4
public class BOJ_1504_특정한최단경로 {

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge() {
		}

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(to=" + to + ", weight=" + weight + ")";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, E, necc1, necc2;
	static ArrayList<Edge>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edge[from].add(new Edge(to, weight));
			edge[to].add(new Edge(from, weight));// 양방향
		}

		st = new StringTokenizer(br.readLine().trim(), " ");
		necc1 = Integer.parseInt(st.nextToken());
		necc2 = Integer.parseInt(st.nextToken());

		long temp1 = dijkstra(1, necc1) + dijkstra(necc1, necc2) + dijkstra(necc2, N);
		long temp2 = dijkstra(1, necc2) + dijkstra(necc2, necc1) + dijkstra(necc1, N);
		long answer = Math.min(temp1, temp2);
		System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
	}

	public static long dijkstra(int start, int end) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		// dist 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작정점 초기화
		dist[start] = 0;

		PriorityQueue<Edge> pque = new PriorityQueue<>();
		pque.offer(new Edge(start, 0));

		while (!pque.isEmpty()) {
			Edge curr = pque.poll();

			if (visited[curr.to]) {
				continue;
			}
			visited[curr.to] = true;

			for (Edge e : edge[curr.to]) {
				if (!visited[e.to]) {
					dist[e.to] = Math.min(dist[e.to], dist[curr.to] + e.weight);
					pque.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		return dist[end];
	}
}
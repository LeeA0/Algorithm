package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준_최소비용구하기_1916_골드5
public class BOJ_1916_최소비용구하기_using_PQ {
	static class Edge implements Comparable<Edge> {
		int to; // 목적지
		int weight; // 가중치

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N, M;
	static ArrayList<Edge>[] adjlist;
	static final int infinite = Integer.MAX_VALUE;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());

		// 인접리스트의 edge를 생성
		adjlist = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adjlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjlist[from].add(new Edge(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(start, end));
	}

	public static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[N+1]; // 해당 정점 방문여부 표시
		int[] dist = new int[N+1]; // 해당 정점에서 제일 최소인 비용을 저장

		// dist배열을 최대 값으로 초기화
		for (int i = 1; i <= N; i++) {
			dist[i] = infinite;
		}
		// 시작정점 비용 초기화
		dist[start] = 0;

		PriorityQueue<Edge> pque = new PriorityQueue<>();
		pque.offer(new Edge(start,0));

		while (!pque.isEmpty()) {
			Edge curr = pque.poll();
			if(visited[curr.to]) {
				continue;
			}
			visited[curr.to]=true;
			
			for (Edge e : adjlist[curr.to]) {
				if(!visited[e.to]) {
					dist[e.to] = Math.min(dist[e.to], dist[curr.to]+e.weight);
					pque.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		return dist[end];
	}
}

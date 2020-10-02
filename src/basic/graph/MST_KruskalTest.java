package basic.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

==>10
----------------------------------

7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14

==>31

 */
public class MST_KruskalTest {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgelist;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgelist = new Edge[E];
		parents = new int[V];

		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 응용 문제 : 이거를 바로 입력하는 것이 아닌 가공이 필요한 문제.
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			edgelist[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgelist);
		
		make();
		
		int cnt = 0, result = 0;
		for (Edge edge : edgelist) {
			if (union(edge.from, edge.to)) {// 싸이클이 형성되지 않았다면
				result += edge.weight;
				if (++cnt == V - 1) {
					break;
				}
			}
		}
		System.out.println(result);
	}

	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}
}

package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//SW_하나로_1251_D4
//kruskal : 비용이 가작 작은 간선을 선택하여 신장트리 처리
public class Solution_1251_하나로 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static int T, N;
	static double E;
	static ArrayList<Point> islandlist;
	static ArrayList<Edge> edgelist;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());

			islandlist = new ArrayList<>();

			StringTokenizer st1 = new StringTokenizer(br.readLine().trim(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				islandlist.add(new Point(x, y));
			}

			E = Double.parseDouble(br.readLine().trim());
			edgelist = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					Point a = islandlist.get(i);
					Point b = islandlist.get(j);
					// 나중에 E곱할거임.
					// 거리계산 시 꼭 pow를 사용!!
					long weight = (long) (Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
					edgelist.add(new Edge(i, j, weight));
				}
			}

			// 비용이 적은 간선부터
			Collections.sort(edgelist);

			parents = new int[N];

			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}

			int cnt = 0;
			long result = 0;
			for (Edge edge : edgelist) {
				if (union(edge.from, edge.to)) {// 싸이클이 형성되지 않았다면
					result += edge.weight;
					if (++cnt == N - 1) {
						break;
					}
				}
			}
			System.out.println("#" + t + " " + Math.round(E * result));
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

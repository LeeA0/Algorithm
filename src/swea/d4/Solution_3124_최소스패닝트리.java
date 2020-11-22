package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_최소스패닝트리_3124_D4
public class Solution_3124_최소스패닝트리 {

	static class Node implements Comparable<Node> {

		int A;// 정점 V
		int B;
		int C;// 가중치 W

		public Node(int a, int b, int c) {
			A = a;
			B = b;
			C = c;
		}

		public Node() {
		}

		@Override
		public int compareTo(Node n) { // 가중치로 정렬 ASC
			if (this.C - n.C > 0) {
				return 1;
			} else if (this.C - n.C < 0) {
				return -1;
			} else
				return 0;
		}

	}

	static int T;
	static int[] p;
	static long res; // 중요 -> 여러개를 곱하다보면 int의 범위를 넘음.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim()); // 12
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int V = Integer.parseInt(st.nextToken().trim());
			int E = Integer.parseInt(st.nextToken().trim());
			Queue<Node> pque = new PriorityQueue<>();
			p = new int[V + 1];
			for (int i = 0; i < p.length; i++) {
				p[i] = i; // make set
			}
			for (int i = 0; i < E; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
				int A = Integer.parseInt(st2.nextToken().trim());
				int B = Integer.parseInt(st2.nextToken().trim());
				int C = Integer.parseInt(st2.nextToken().trim());
				pque.add(new Node(A, B, C));
			}
			res = 0L;
			while (!pque.isEmpty()) {
				Node cu = pque.poll();
				union(cu);
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static void union(Node cu) {
		int x = find(cu.A);
		int y = find(cu.B);
		if (x != y) { // 폐공간이 아니면 합친다.
			p[y] = x;
			res += cu.C;
		}
	}

	private static int find(int x) {
		if (x == p[x]) {
			return x;
		} else
			return p[x] = find(p[x]);
	}
}

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_연결요소의 개수_11724_실버2
public class BOJ_11724_연결요소의개수 {
	static int N, M;
	static int[] parents, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		rank = new int[N + 1];

		// make
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(i==find(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) {
			return;
		}
		// 랭크가 큰거에 합쳐줘야 깊이가 덜 깊어짐
		if (rank[pa] < rank[pb]) {
			parents[pa] = pb;
		} else {
			parents[pb] = pa;
			if (rank[pa] == rank[pb]) {
				rank[pa]++;
			}
		}
	}

	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		} else {
			return parents[a] = find(parents[a]);
		}
	}
}

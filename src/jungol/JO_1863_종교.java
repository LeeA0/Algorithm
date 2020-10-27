package jungol;

import java.util.Scanner;

//정올_종교_1863
public class JO_1863_종교 {
	static int n, m, cnt;
	static int[] parents, rank;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		// parents생성
		parents = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			make(i);
		}
		// 쌍 입력
		m = scan.nextInt();
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			union(a, b);
		}
		cnt = 0;
		// 가지 수 세기
		for (int i = 1; i < n + 1; i++) {
			if (find(i) == i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void make(int a) {
		parents[a] = a;
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) {
			return;
		}
		if (rank[pa] < rank[pb])
			parents[pa] = pb;
		else {
			parents[pb] = pa;
			if (rank[pa] == rank[pb]) {
				rank[pa]++;
			}
		}
	}
}

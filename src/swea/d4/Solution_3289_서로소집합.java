package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SW_서로소집합_3289_D4
public class Solution_3289_서로소집합 {
	static int T, N, M;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder("#").append(t).append(" ");
			String[] temp = br.readLine().trim().split(" ");
			N = Integer.parseInt(temp[0]);
			parents = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				make(i);
			}
			M = Integer.parseInt(temp[1]);

			for (int i = 0; i < M; i++) {
				temp = br.readLine().trim().split(" ");
				int key = Integer.parseInt(temp[0]);
				int a = Integer.parseInt(temp[1]);
				int b = Integer.parseInt(temp[2]);
				switch (key) {
				case 0:
					union(a, b);
					break;
				case 1:
					/*
					 * if(a == find(b)) { sb.append(1); } else { sb.append(0); }
					 */
					sb.append((find(a) == find(b)) ? 1 : 0);
					break;
				}
			}
			System.out.println(sb.toString());
		}
	}

	private static void make(int a) {
		parents[a] = a;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a; // 자신이 루트노드라면 자기노드번호 리턴
		return parents[a] = find(parents[a]); // 자신의 부모를 따라 결국 루트노드를 찾아 리턴받고 자신의 부모를 자기 트리의 루트노드로 갱신하여 트리의 depth를 줄인다.
	}

	private static void union(int a, int b) {
		int pa = find(a); // a노드가 속해 있는 트리(그룹)의 루트노드 찾기
		int pb = find(b); // b노드가 속해 있는 트리(그룹)의 루트노드 찾기
		// 두 노드의 루트노드가 다르다면 한쪽 트리에 다른 트리 합치기
		if (pa != pb)
			parents[pb] = pa;
	}
}

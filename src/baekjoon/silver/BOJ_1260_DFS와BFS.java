package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준_DFS와 BFS_1260_실버2
public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static boolean[][] admatrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();

		admatrix = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			admatrix[from][to] = true;
			admatrix[to][from] = true;
		}
		dfs(V);
		System.out.println(sb.toString());
		visited = new boolean[N + 1];
		bfs(V);
	}

	public static void dfs(int V) {
		//이미 방문한 정점이면 return;
		if (visited[V]) {
			return;
		}
		//아니면
		visited[V] = true;
		sb.append(V).append(" ");
		for (int i = 1; i <= N; i++) {
			if (admatrix[V][i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int n) {
		sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
		visited[V] = true;
		que.offer(V);
		sb.append(V);
		while (!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 1; i <= N; i++) {
				if (admatrix[curr][i]) {
					if (visited[i]) {
						continue;
					}
					visited[i] = true;
					que.offer(i);
					sb.append(" ").append(i);
				}
			}
		}
		System.out.println(sb.toString());
	}
}

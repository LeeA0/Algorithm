package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//시간될때 wall대신 cnt를 넣어보자..
//->그랬더니 성공 축축

//백준_알고스팟_1261_골드4
public class BOJ_1261_알고스팟 {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	static int N, M, answer;
	static int[][] map;
	static boolean[][] v;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		bfs(0, 0);
	}

	public static void bfs(int x, int y) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(x, y, map[x][y]));
		v[x][y] = true;
		while (!que.isEmpty()) {
			Node curr = que.poll();
			if (curr.x == N - 1 && curr.y == M - 1) {
				System.out.println(curr.dist);
				break;
			}
			for (int d[] : dir4) {
				int nx = curr.x + d[0];
				int ny = curr.y + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (!v[nx][ny]) {
					v[nx][ny] = true;
					if (map[nx][ny] == 1) {
						que.offer(new Node(nx, ny, curr.dist + 1));
					} else {
						que.offer(new Node(nx, ny, curr.dist));
					}
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

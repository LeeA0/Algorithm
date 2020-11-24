package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_탈주범검거_1953
public class Solution_1953_탈주범검거_using_bfs {

	static int T, N, M, R, C, L;
	static int[][] map;
	// 상하좌우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] pipe = { { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		boolean[][] visited = new boolean[N][M]; // 방문처리

		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { R, C });
		visited[R][C] = true;

		int count = 1; //
		int time = 1;

		while (time < L && !que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] curr = que.poll();
				for (int d : pipe[map[curr[0]][curr[1]] - 1]) {
					int nx = curr[0] + dir4[d][0];
					int ny = curr[1] + dir4[d][1];
					if (!check(nx, ny)) {
						continue;
					}
					if (!visited[nx][ny] && map[nx][ny] != 0 && contain(d, nx, ny)) {
						que.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
						count++;
					}
				}
			}
			//print(visited);
			time++;
		}
		return count;
	}

	// 이어져 있는 파이프인지 판별
	private static boolean contain(int d, int nx, int ny) {
		int[] temp = pipe[map[nx][ny] - 1];
		switch (d) {
		case 0: //상
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]==1) { //하
					return true;
				}
			}
			break;
		case 1: //하
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]==0) { //상
					return true;
				}
			}
			break;
		case 2: //좌
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]==3) { //우
					return true;
				}
			}
			break;
		case 3: //우
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]==2) { //좌
					return true;
				}
			}
			break;
		}
		return false;
	}

	private static void print(boolean[][] visited) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("================");
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

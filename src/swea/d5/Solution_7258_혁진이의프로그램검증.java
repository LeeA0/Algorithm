package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_혁진이의프로그램검증_7258_D5
public class Solution_7258_혁진이의프로그램검증 {
	static class Order {
		int x;
		int y;
		int m;
		int d;

		public Order(int x, int y, int m, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.d = d;
		}
	}

	static int T, R, C;
	static char[][] map;
	// 상 하 좌 우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				char[] temp = br.readLine().trim().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = temp[j];
				}
			}

			System.out.println("#" + t + " " + (bfs() ? "YES" : "NO"));

		}
	}

	private static boolean bfs() {
		Queue<Order> que = new LinkedList<Order>();
		que.offer(new Order(0, 0, 0, 3));
		boolean[][][][] visited = new boolean[R][C][16][4];
		while (!que.isEmpty()) {
			Order curr = que.poll();
			if(visited[curr.x][curr.y][curr.m][curr.d])
                continue;
			visited[curr.x][curr.y][curr.m][curr.d] = true;
			// 현채 위치에 대한 처리
			int nd = curr.d;
			int nm = curr.m;
			switch (map[curr.x][curr.y]) {
			case '@':
				return true;
			case '<':
				nd = 2;
				break;
			case '>':
				nd = 3;
				break;
			case '^':
				nd = 0;
				break;
			case 'v':
				nd = 1;
				break;
			case '_':
				if (nm == 0) {
					nd = 3;
				} else {
					nd = 2;
				}
				break;
			case '|':
				if (nm == 0) {
					nd = 1;
				} else {
					nd = 0;
				}
				break;
			case '?':
				nd = 5;
				break;
			case '.':
				break;
			case '+':
				nm = (nm + 1) % 16;
				break;
			case '-':
				nm = nm - 1 < 0 ? 15 : nm - 1;
				break;
			default: // 0~9일 때
				nm = map[curr.x][curr.y] - '0';
				break;
			}
			if (nd == 5) {
				for (int d = 0; d < 4; d++) {
					if (d != nd) {
						int nx = (curr.x + dir4[d][0]) % R;
						if (nx < 0)
							nx += R;
						int ny = (curr.y + dir4[d][1]) % C;
						if (ny < 0)
							ny += C;
						que.offer(new Order(nx, ny, nm, d));
					}
				}
			} else {
				int nx = (curr.x + dir4[nd][0]) % R;
				if (nx < 0)
					nx += R;
				int ny = (curr.y + dir4[nd][1]) % C;
				if (ny < 0)
					ny += C;
				que.offer(new Order(nx, ny, nm, nd));
			}
		}
		return false;
	}
}

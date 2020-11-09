package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs_Queue 2개 이용
//백준_탈출_3055_골드5
public class BOJ_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		Queue<int[]> water = new LinkedList<int[]>();
		Queue<int[]> dochi = new LinkedList<int[]>();
		int[] end = new int[2];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}
				if (map[i][j] == 'S') {
					dochi.add(new int[] { i, j });
					map[i][j] = '.';
					visited[i][j]=true;
				}
				if (map[i][j] == 'D') {
					end[0] = i;
					end[1] = j;
				}
			}
		} // 입력완료

		int time = 0;
		boolean reach = false;
		a: while (!dochi.isEmpty()) {
			time++;
			// 물 이동
			int water_size = water.size();
			for (int i = 0; i < water_size; i++) {
				int[] curr_w = water.poll();
				for (int[] d : dir4) {
					int wx = curr_w[0] + d[0];
					int wy = curr_w[1] + d[1];
					if (!check(wx, wy)) {
						continue;
					}
					if (map[wx][wy] == '.') {
						map[wx][wy] = '*';
						water.offer(new int[] { wx, wy });
					}
				}
			}
			// 고슴도치 이동
			int dochi_size = dochi.size();
			for (int i = 0; i < dochi_size; i++) {
				int[] curr_d = dochi.poll();
				for (int[] d : dir4) {
					int dx = curr_d[0] + d[0];
					int dy = curr_d[1] + d[1];
					if (!check(dx, dy)) {
						continue;
					}
					if(map[dx][dy]=='.'&&!visited[dx][dy]) {
						dochi.offer(new int[] {dx,dy});
						visited[dx][dy]=true;
					}
					if(dx==end[0]&&dy==end[1]) {
						reach=true;
						break a;
					}
				}
			}
		}
		if(reach) {
			System.out.println(time);
		}else {
			System.out.println("KAKTUS");
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}
}

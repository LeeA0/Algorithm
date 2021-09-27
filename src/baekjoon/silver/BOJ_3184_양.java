package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_3184_양_실버2
public class BOJ_3184_양 {
	static int R, C, wolfTotalNum, shipTotalNum;
	static char[][] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		isVisited = new boolean[R][C];
		wolfTotalNum = 0;
		shipTotalNum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isVisited[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')) {
					fight(i, j);
				}
			}
		}

		System.out.println(shipTotalNum + " " + wolfTotalNum);
	}

	public static void fight(int x, int y) {
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int wolfNum = 0;
		int shipNum = 0;

		Queue<int[]> location = new LinkedList<int[]>();
		location.offer(new int[] { x, y });
		if (map[x][y] == 'o') {
			shipNum++;
		} else {
			wolfNum++;
		}
		isVisited[x][y] = true;

		while (!location.isEmpty()) {
			int[] curr = location.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!isBoundary(nx, ny) || isVisited[nx][ny] || map[nx][ny] == '#') {
					continue;
				}
				location.offer(new int[] { nx, ny });
				if (map[nx][ny] == 'o') {
					shipNum++;
				} else if(map[nx][ny] == 'v'){
					wolfNum++;
				}
				isVisited[nx][ny] = true;
			}
		}
		if (shipNum > wolfNum) {
			shipTotalNum += shipNum;
		} else {
			wolfTotalNum += wolfNum;
		}
	}

	public static boolean isBoundary(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}

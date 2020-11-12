package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SW_오!나의여신님_7793_D5
public class Solution_7793_오나의여신님 {
	static int T, N, M, sx, sy;
	static boolean[][] visited;
	static char[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						map[i][j]='.';
						sx = i;
						sy = j;
					}
				}
			}

			// 수연이 이동
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] { sx, sy });
			int count = 1;
			visited[sx][sy]=true;

			boolean goal = false;
			a: while (!que.isEmpty()) {
				// 악마의 손아귀 셋팅
				setDevil();

				int size = que.size();
				for (int i = 0; i < size; i++) {
					int[] curr = que.poll();
					for (int[] d : dir4) {
						int nx = curr[0] + d[0];
						int ny = curr[1] + d[1];
						if (!check(nx, ny)||visited[nx][ny]) {
							continue;
						}
						if (map[nx][ny] == 'D') {
							goal = true;
							break a;
						}
						if (map[nx][ny] == '.') {
							visited[nx][ny]=true;
							que.offer(new int[] { nx, ny });
						}
					}
					
//					// map출력
//					for (int i = 0; i < N; i++) {
//						for (int j = 0; j < M; j++) {
//							System.out.print(map[i][j] + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("================");
				}
//				//visted출력
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(visited[i][j] + " ");
//					}
//					System.out.println();
//			}
				count++;
			}

			if (goal) {
				System.out.print("#" + t + " ");
				System.out.println(count);
			} else {
				System.out.println("#" + t + " " + "GAME OVER");
			}
		}

	}

	public static void setDevil() {
		// 변형될 곳 표시
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') {
					for (int[] d : dir4) {
						int nx = i + d[0];
						int ny = j + d[1];
						if (!check(nx, ny)) {
							continue;
						}
						if (map[nx][ny] == '.') {
							map[nx][ny] = '@';
						}
					}
				}
			}
		}
		// 변형
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '@') {
					map[i][j] = '*';
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

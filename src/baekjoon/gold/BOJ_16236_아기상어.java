package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 3일만에 성공...
// 백준_아기상어_16236_골드5
public class BOJ_16236_아기상어 {
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int time;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x < o.x) {
				return -1;
			} else if (this.x == o.x) {
				if (this.y < o.y) {
					return -1;
				}
			}
			return 1;
		}
	}

	// x,y : 상어의 처음 위치 값
	// size : 상어의 처음 사이즈
	// cnt : 크기가 변한 이후 먹은 물고기 수
	static int N, x, y, size, cnt;
	static int[][] map;
	static Point shark;
	// 우선순위에 따라 방향 설정
	// 상 좌 우 하
	static int[][] dir4 = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Point(i, j, 0);
				}
			}
		}

		size = 2;
		cnt = 0;
		map[shark.x][shark.y] = 0;
		while (true) {
			// 가장 가까운 지점을 찾음(상어의 크기보다 작은 것), 같은 크기도 지나갈 수 있음.
			// 우선순위 : 1.위 2.왼쪽
			// bfs이용?
			Point fish = bfs(shark);
			if (fish == null) {
				break;
			}
			// 그 지점으로 이동해서 물고기를 먹음, 사이즈만큼 먹으면 크기 up!
			// 깊은 복사
			shark.x = fish.x;
			shark.y = fish.y;
			shark.time = fish.time;

			// 물고기 먹었다는 표시
			map[shark.x][shark.y] = 0;
			cnt++;

//			System.out.println(shark.x + " " + shark.y + " " + size + " " + shark.time);
//			print();

			// 사이즈만큼 물고기를 먹으면 크기 up!
			if (cnt == size) {
				size++;
				cnt = 0;
			}
		}
		System.out.println(shark.time);

	}

//	public static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("=====================");
//	}

	public static Point bfs(Point shark) {
		boolean[][] visited = new boolean[N][N];
		visited[shark.x][shark.y] = true;
		Queue<Point> que = new LinkedList<>();
		que.offer(shark);
		while (!que.isEmpty()) {
			int qsize = que.size();
			for (int i = 0; i < qsize; i++) {
				Point curr = que.poll();
				for (int[] d : dir4) {
					int nx = curr.x + d[0];
					int ny = curr.y + d[1];
					int time = curr.time;
					if (!check(nx, ny) || visited[nx][ny]) {
						continue;
					}
					// 0이거나 같은 크기의 물고기면 지나갈 수 있음.
					if (map[nx][ny] == 0 || map[nx][ny] == size) {
						que.offer(new Point(nx, ny, time + 1));
						visited[nx][ny] = true;
					}
					// 맨처음 발견한 물고기가 제일 가까운 물고기 일테니 상관 ㄴ
					else if (map[nx][ny] < size) {
						que.offer(new Point(nx, ny, time + 1));
						visited[nx][ny] = true;
						// return new Point(nx, ny, time + 1);
					}
				}
			}
			LinkedList<Point> list = (LinkedList<Point>) que;
			Collections.sort(list);
			for (Point temp : list) {
				int tx = temp.x;
				int ty = temp.y;
				if (map[tx][ty] != 0 && map[tx][ty] < size) {
					return temp;
				}
			}
		}
		return null;
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

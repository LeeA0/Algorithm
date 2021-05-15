package programmers;

import java.util.LinkedList;
import java.util.Queue;

// Programmers_게임맵최단거리_level2
public class Programmers_게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = { { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = 1;
		int N = maps.length;
		int M = maps[0].length;
		// 4방향
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 도착했는지 아닌지
		boolean goal = false;
		
		// 시작지점이 0이면 못가므로 0이 아니면 이동시작
		if (maps[0][0] != 0) {
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] { 0, 0 });
			// 방문여부 체크 배열
			boolean[][] visited = new boolean[N][M];
			visited[0][0] = true;
			a:while (!que.isEmpty()) {
				answer++;
				// 이동거리를 측정하기위해 size를 저장해서 이동
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int[] curr = que.poll();
					// 4방향
					for (int[] d : dir4) {
						// 이동
						int nx = curr[0] + d[0];
						int ny = curr[1] + d[1];
						// 범위에서 벗어났거나, 벽이거나, 이미 방문했으면 넘어감
						if (!check(nx, ny, N, M) || maps[nx][ny] == 0 || visited[nx][ny]) {
							continue;
						}
						// 도착했으면 goal을 true변경하고 이동을 중단
						if (nx == N - 1 && ny == M - 1) {
							goal = true;
							break a;
						}
						// 도착아니면 다음으로 이동할 수 있게 저장
						que.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}

		// 도착했으면 이동거리, 아니면 -1출력
		return goal ? answer : -1;
	}

	public static boolean check(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}

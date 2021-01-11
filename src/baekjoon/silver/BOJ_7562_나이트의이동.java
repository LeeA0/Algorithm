package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_나이트의 이동_7562_실버2
public class BOJ_7562_나이트의이동 {
	// I: 체스판 크기
	// sx: 나이트가 현재있는 위치의 x좌표, sy: 나이트가 현재있는 위치의 y좌표
	// ex: 나이트가 이동하려고 하는 칸의 x좌표, ey: 나이트가 이동하려고 하는 칸의 y좌표
	static int I, sx, sy, ex, ey;
	// 체스판
	static int[][] map;
	// 나이트의 이동가능 방향
	static int[][] dir8 = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			I = Integer.parseInt(br.readLine().trim());
			map = new int[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			// 입력완료

			// 이미 현재지점과 목표지점이 같으면 이동횟수 0
			if (sx == ex && sy == ey) {
				System.out.println(0);
			} else {
				// 맨처음 지점 체크를 위해 1부터 시작하므로 리턴된 값에서 -1해줌
				System.out.println(bfs() - 1);
			}
		}
	}

	public static int bfs() {
		// 목표지점까지 도달하는데 걸리는 최소횟수를 구하는 것은 깊게 들어가는 것 보다 다양한 경우의 수를 넓게 들어가는 것이 유리하므로
		// 너비우선 탑색을 위해 queue를 선언
		Queue<int[]> que = new LinkedList<int[]>();
		// 시작 지점을 넣음
		que.offer(new int[] { sx, sy });
		// 시작점 방문체크를 위하여 1로 표시
		map[sx][sy] = 1;
		// 큐가 비어있지 않은 동안 반복
		while (!que.isEmpty()) {
			// queue안에 있는 것 중 가장 먼저 들어왔던 것 중 하나를 현재 위치로 저장
			int[] curr = que.poll();
			// 이동가능한 8방향으로 이동
			for (int[] d : dir8) {
				// 해당 방향으로 이동했을 때의 nx,ny
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				// 맵의 영역에 벗어났거나 이미 한번 방문했던 곳이면 지나침
				if (!check(nx, ny) || map[nx][ny] != 0) {
					continue;
				}
				// 지금 이동횟수는 이전 이동횟수+1이므로 이를 계산해서 넣어줌
				map[nx][ny] = map[curr[0]][curr[1]] + 1;
				// 목표 지점에 도달하면
				if (nx == ex && ny == ey)
					// 현재 이동회수를 반환
					return map[nx][ny];
				// 목표지점에 도달한게 아니면 새로운 지점을 queue에 저장
				que.offer(new int[] { nx, ny });
			}
		}
		return -1;
	}

	public static boolean check(int x, int y) {
		return (x >= 0 && x < I && y >= 0 && y < I);
	}
}

package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_스타트택시_19238_골드4
public class BOJ_19238_스타트택시 {
	// 승객 객체
	static class Passenger implements Comparable<Passenger> {
		// 승객 출발지점
		int sx;
		int sy;
		// 승객 도착지점
		int ex;
		int ey;

		public Passenger(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}

		@Override
		public int compareTo(Passenger o) {
			if (this.sx != o.sx) {
				return Integer.compare(this.sx, o.sx);
			}
			return Integer.compare(this.sy, o.sy);
		}
	}

	// N: 맵 크기
	// M: 승객 수
	// oil: 연로
	// tx, ty: 택시 위치
	static int N, M, oil, tx, ty;
	// 택시의 활동 영역
	static boolean[][] map;
	// 승객의 위치를 저장하는 리스트
	static LinkedList<Passenger> passengerList;
	// 상하좌우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 1이면 true, true면 갈 수 없다
				map[i][j] = st.nextToken().equals("1");
			}
		}
		st = new StringTokenizer(br.readLine());
		// 좌표가 1부터 표시되므로 0부터 시작하기 위해 빼줌
		tx = Integer.parseInt(st.nextToken()) - 1;
		ty = Integer.parseInt(st.nextToken()) - 1;
		passengerList = new LinkedList<>();

		// 승객의 위치를 파악하여 택시와의 거리 계산을 좀 더 편하게 할 수 있다
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			passengerList.add(new Passenger(sx, sy, ex, ey));
		}

		// 택시 활동
		taxi();

		// 남은 연로를 출력한다
		// 모든 손님을 이동시킬 수 없거나 이동도중 연료가 바닥나면 -1을 출력
		System.out.println(oil);
	}

	static void taxi() {
		// 모든 승객을 목적지까지 이동시킬 때까지 반복
		while (passengerList.size() > 0) {
			// 거리가 같을 경우 행이 좀 더 작은 승객, 행이 같은 경우 열이 더 작은 승객을 먼저 태워야하므로 정렬
			Collections.sort(passengerList);
			// 택시와의 거리가 가장 적은 승객과의 거리
			int min_dist = Integer.MAX_VALUE;
			// 택시와의 거리가 가장 적은 승객의 인덱스
			int min_idx = 0;
			for (int i = 0; i < passengerList.size(); i++) {
				// 각 승객과 택시의 거리를 구한다
				int dist = getDist(passengerList.get(i).sx, passengerList.get(i).sy);
				// 거리가 -1이면 승객에게 갈 수 없다는 뜻이므로 -1로 리턴
				if (dist == -1) {
					oil = -1;
					return;
				}
				// 최소 거리 승객 갱신
				if (min_dist > dist) {
					min_dist = dist;
					min_idx = i;
				}
			}
			// 택시와의 거리가 최소인 승객을 태운다
			Passenger nextPassenger = passengerList.get(min_idx);
			// 승객이 택시에 탔으므로 리스트에서 제거
			passengerList.remove(min_idx);

			// 택시가 승객의 위치까지 이동하는데 사용하고 남은 연료 계산
			oil -= min_dist;
			// 0보다 작으면 연료가 다 떨어져 승객에게 갈 수 없으므로 -1을 리턴
			if (oil < 0) {
				oil = -1;
				return;
			}
			// 택시가 승객에게 이동했으므로 택시위치를 승객의 출발지 위치로 변경
			tx = nextPassenger.sx;
			ty = nextPassenger.sy;
			// 승객의 출발지부터 목적지까지의 거리를 계산
			int goalDist = getDist(nextPassenger.ex, nextPassenger.ey);
			// 출발지부터 목적지까지 이동하면서 사용하고 남은 연료 계산
			oil -= goalDist;
			// 0보다 작으면 연료가 다 떨어져 목적지로 갈 수 없으므로 -1을 리턴
			if (oil < 0) {
				oil = -1;
				return;
			}
			// 목적지에 도착했으므로, 택시의 위치를 승객의 목적지점으로 변경
			tx = nextPassenger.ex;
			ty = nextPassenger.ey;
			// 목적지에 무사히 도착했으므로, 출발지부터 목적지까지 이동하면서 사용한 연료의 2배를 충전
			oil += goalDist * 2;
		}
	}

	// 택시와 목적지점(gx, gy)까지의 거리를 반환
	static int getDist(int gx, int gy) {
		// 이미 목적지점에 택시가 위치하면 거리는 0으로 반환
		if (gx == tx && gy == ty) {
			return 0;
		}
		// 이동 거리 계산을 위한 Queue 선언
		Queue<int[]> que = new LinkedList<>();
		// 택시의 위치 저장
		que.offer(new int[] { tx, ty });
		// 해당 지점을 택시가 지나갔는지 체크하는 배열
		int[][] isVisited = new int[N][N];
		// 출발지점에 방문 표시
		isVisited[tx][ty] = 1;
		// Queue가 비어있지 않은 동안 반복
		while (!que.isEmpty()) {
			// Queue에서 택시의 현재 위치를 받음
			int[] curr = que.poll();
			// 4방향으로 가는 경우의 수
			for (int[] d : dir4) {
				// 해당 방향으로 택시 이동
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				// 이동한 위치가 범위에서 벗어났거나, 벽이거나, 방문했던 곳이면 건너뜀
				if (!check(nx, ny) || map[nx][ny] || isVisited[nx][ny] > 0) {
					continue;
				}
				// 이동한 위치가 목표지점과 일치하면 이동거리를 반환
				if (nx == gx && ny == gy) {
					return isVisited[curr[0]][curr[1]];
				}
				// 다음 위치로 이동하기위해 현재 위치를 Queue에 저장
				que.offer(new int[] { nx, ny });
				// 현재지점의 최단 거리를 저장함으로써 방문했다는 표시를 남김
				isVisited[nx][ny] = isVisited[curr[0]][curr[1]] + 1;
			}
		}
		// 모든 곳을 돌았는데도 목적지에 도달하지 못했다면, 목적지를 갈 수 없는 것이므로 -1 리턴
		return -1;
	}

	// 해당 지점(x, y)이 지도의 영역에서 벗어났는지 체크
	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

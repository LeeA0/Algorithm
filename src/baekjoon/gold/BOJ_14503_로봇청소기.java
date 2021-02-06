package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_로봇청소기_14503_꼴드5
public class BOJ_14503_로봇청소기 {
	static int N, M, cnt;
	static int[][] map;
	// 북 서 남 동
	static int[][] dir4 = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 맵의 세로길이(행 수)
		N = Integer.parseInt(st.nextToken());
		// 맵의 가로길이(열 수)
		M = Integer.parseInt(st.nextToken());
		// 맵 선언
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		// 로봇청소기의 현재 행위치
		int r = Integer.parseInt(st.nextToken());
		// 로봇청소기의 현재 열위치
		int c = Integer.parseInt(st.nextToken());
		// 로봇청소기가 현재 바라보고있는 방향
		int d = Integer.parseInt(st.nextToken());

		// 입력받는 방향(북,동,남,서)과 도는 방향(북,서,남,동)을 맞추기위해
		// 서: 3 -> 1
		// 동: 1 -> 3
		if (d == 1)
			d = 3;
		else if (d == 3)
			d = 1;

		// 맵에 정보 입력(0: 빈공간, 1: 벽)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		// 초기 위치,방향을 넣어서 로봇청소기를 이동
		dfs(r, c, d);
		System.out.println(cnt);
	}

	// x: 세로위치
	// y: 가로위치
	// d: 해당 칸에 들어왔을 때 바라보고 있는 방향
	static void dfs(int x, int y, int d) {
		// 후진을 해야하는 지 아닌지 체크
		boolean back = true;
		// 만약 이미 청소하지 않았던 곳이면
		if (map[x][y] != 2) {
			// 청소했다는 표시
			map[x][y] = 2;
			// 청소한 곳 카운트
			cnt++;
		}
		// 4방향의 왼쪽을 탐색해야 하므로 +1을 해주어 탐색을 시작 
		for (int i = 1; i < 5; i++) {
			// 해당 방향의 왼쪽방향 계산
			int nd = (d + i) % 4;
			// 왼쪽 방향의 좌표 값 계산
			int nx = x + dir4[nd][0];
			int ny = y + dir4[nd][1];
			// 왼쪽방향이 벽이거나 이미 청소가 되어있으면 스킵
			if (map[nx][ny] == 1 || map[nx][ny] == 2)
				continue;
			// 청소가 안되어있다면 이동
			dfs(nx, ny, nd);
			// 앞에서 이동했으므로 후진할 필요가 없다
			back = false;
			break;
		}
		// 4방향 전부 청소가 되어있거나, 벽이면 후진
		if (back) {
			// 현재 바라보고있는 방향을 기중으로 후진
			int nd = (d + 2) % 4;
			// 후진한 좌표 값 계산
			int nx = x + dir4[nd][0];
			int ny = y + dir4[nd][1];
			// 후진한 곳이 벽이 아니면
			if (map[nx][ny] != 1) {
				// 후진해서 다시 기능을 수행
				dfs(nx, ny, d);
			}
		}
	}
}

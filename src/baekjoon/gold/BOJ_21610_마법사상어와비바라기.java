package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_21610_마법사상어와비바라기_골드5

public class BOJ_21610_마법사상어와비바라기 {
	// N: 맵의 크기
	// M: 이동명령 개수
	static int N, M;
	// 물의 양을 담을 맵
	static int[][] map;
	// 해당 칸에 구름이 있는지 여부
	static boolean[][] cloud;
	// 8방
	static int[][] dir8 = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
	// 대각선 4방
	static int[][] dir4 = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력

		// 구름 위치 초기화
		cloud = new boolean[N][N];
		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;
		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;
		
		// M개의 이동 명령 실행
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			// 이동 방향
			int d = Integer.parseInt(st.nextToken());
			// 이동 거리
			int s = Integer.parseInt(st.nextToken());
			// 구름을 d방향으로 s만큼 이동시키고 비를 내림
			moveAndRain(d, s);
			// 물복사버그 마법
			waterCopy();
			// 구름 생성
			makeCloud();
		}
		// 바구니에 들어있는 물의 양의 합계
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				num += map[i][j];
			}
		}
		System.out.println(num);
	}

	// 구름을 생성
	public static void makeCloud() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// 물의 양이 2이상이고, 기존에 구름이 있다가 사라진 부분이 아닌 곳은 구름을 생성
				if (map[x][y] >= 2 && !cloud[x][y]) {
					map[x][y] -= 2;
					cloud[x][y] = true;
				}
				// 기존에 구름이 있다가 사라진 부분이면 구름을 만들 수 없음
				else if (cloud[x][y]) {
					cloud[x][y] = false;
				}
			}
		}
	}

	// 물복사 버그
	public static void waterCopy() {
		// 물이 증가하는 양을 저장하는 배열
		int[][] increateWater = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// 물이 증가한 칸(구름이 있던 칸)에 물복사버그 마법을 시전
				if (cloud[x][y]) {
					// 대각선 방향을 확인
					for (int[] d : dir4) {
						int nx = x + d[0];
						int ny = y + d[1];
						// 범위를 벗어났거나, 물이 없는 곳이면 세지 않음
						if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || map[nx][ny] == 0) {
							continue;
						}
						increateWater[x][y]++;
					}
				}
			}
		}
		// 증가한 만큼 기존 map에 더해줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += increateWater[i][j];
			}
		}
	}

	// 구름이 이동하고 비가 내림
	public static void moveAndRain(int d, int s) {
		// 구름이 이동한 위치를 저장할 배열
		boolean[][] moveCloud = new boolean[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				// 구름이 있는 곳이면 d의 방향으로 s만큼 이동
				// 이때, 맨끝 행과 열은 연결되어있으므로 나머지 연산 혹은 이동 거리가 음수 값일 때, 맵의 크기를 더해줌
				if (cloud[x][y]) {
					int nx = (x + s * dir8[d - 1][0]) % N;
					if (nx < 0) {
						nx += N;
					}
					int ny = (y + s * dir8[d - 1][1]) % N;
					if (ny < 0) {
						ny += N;
					}
					// 이동한 곳에 구름 처리
					moveCloud[nx][ny] = true;
					// 구름이 생긴 곳에 비가 오므로 물의 양 1증가
					map[nx][ny]++;
				}
			}
		}
		// 이동한 구름위치를 저장
		cloud = moveCloud;
	}
}

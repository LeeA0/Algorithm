package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_2573_빙산_골드4
public class BOJ_2573_빙산 {
	// N: 맵의 행 크기
	// M: 맵의 열 크기
	static int N, M;
	// map: 빙산이 있는 맵
	// dir4: 4방
	static int[][] map, dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력
		
		// 시간
		int time = 0;
		// 시간이 흐르면서 빙산이 녹음
		while (true) {
			time++;
			// 빙산이 녹음
			melt();
			// 빙산 덩어리 개수를 세는 변수
			int cnt = 0;
			// 해당 칸이 이미 빙산 덩어리 개수 체크에 방문했는지 체크하는 배열
			boolean[][] isCounted = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 빙산이고 아직 세지않은 부분이면
					if (map[i][j] != 0 && !isCounted[i][j]) {
						// 빙산 한 개의 크기 탐색
						cntIce(i, j, isCounted);
						// 빙하 개수 1증가
						cnt++;
					}
				}
			}
			// 빙산이 2덩어리 이상이면 더 이상의 반복을 중지하고 해당 시간을 출력
			if (cnt >= 2) {
				break;
			}
			// 빙산이 2덩어리 이상이 되기 전에 전부 녹으면 중지하고 0을 반환
			if (cnt == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}

	// 빙산 하나의 범위를 체크
	public static void cntIce(int x, int y, boolean[][] isCounted) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { x, y });
		// 해당 부분은 현재 빙산에 포함됨
		isCounted[x][y] = true;
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			// 4방으로 탐색하며 연결된 빙산이 있는지 탐색
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				// 범위를 벗어났거나
				// 바닷물이거나
				// 이미 센 부분이면 넘김
				if (!(0 <= nx && nx < N && 0 <= ny && ny < M) || map[nx][ny] == 0 || isCounted[nx][ny]) {
					continue;
				}
				// 아니면 Queue에 넣고 방문처리 후 다음을 실행
				que.offer(new int[] { nx, ny });
				isCounted[nx][ny] = true;
			}
		}
	}

	// 빙산이 녹음
	public static void melt() {
		// 빙산이 몇 개 녹았는지 체크하는 배열
		int[][] meltMap = new int[N][M];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				// 빙산이면
				if (map[x][y] != 0) {
					// 4방에 바닷물이 몇 개있는지 체크
					for (int[] d : dir4) {
						int nx = x + d[0];
						int ny = y + d[1];
						if (!(0 <= nx && nx < N && 0 <= ny && ny < M) || map[nx][ny] != 0) {
							continue;
						}
						meltMap[x][y]++;
					}
				}
			}
		}
		
		// 맵에 빙산의 높이를 업데이트함
		// 만약 빙산이 다 녹아 값이 음수가 되면 0으로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] -= meltMap[i][j];
				map[i][j] = map[i][j] < 0 ? 0 : map[i][j];
			}
		}
	}
}

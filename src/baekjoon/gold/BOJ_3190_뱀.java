package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_뱀_3190_골드5
public class BOJ_3190_뱀 {
	static int N, K, L, answer_time;
	// 우,하,좌,상
	static int[][] map, dir4 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		K = Integer.parseInt(br.readLine().trim());
		map = new int[N + 1][N + 1];
		// 사과 입력
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 5;
		}
		L = Integer.parseInt(br.readLine().trim());
		// 뱀 초기위치 설정
		map[1][1] = 1;
		int hx = 1;
		int hy = 1;
		int tx = 1;
		int ty = 1;
		int d = 0;
		// map에 숫자로 방향을 저장
		// 1: → 2: ↓ 3: ← 4: ↑

		// 시간 측정 변수 초기화
		answer_time = 0;

		boolean out = false;

		// 뱀 이동
		for (int i = 0; i <= L; i++) {
			int time = Integer.MAX_VALUE;
			char dir = 'A';
			if (i >= 0 && i < L) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				time = Integer.parseInt(st.nextToken());
				dir = st.nextToken().charAt(0);
			}
			// 뱀이 이동한다~!
			while (true) {
				// 시간이 흐름
				answer_time++;

				// 머리가 한칸 이동한다~
				hx = hx + dir4[d][0];
				hy = hy + dir4[d][1];

				// 간 곳이 벽이거나 자기자신이면
				if (!check(hx, hy) || (map[hx][hy] >= 1 && map[hx][hy] <= 4)) {
					out = true;
					break;
				}

				// 간 곳이 빈공간이면 꼬리 위치를 한칸 앞으로 이동
				else if (map[hx][hy] == 0) {
					int temp = map[tx][ty] - 1;
					map[tx][ty] = 0; // 몸길이를 줄여 꼬리가 위치한 칸을 비움
					tx = tx + dir4[temp][0];
					ty = ty + dir4[temp][1];
				}

				// 간 곳이 사과면 꼬리 위치 그대로(else)

				// 시간이 다됬을 때
				if (time == answer_time) {
					// 왼쪽
					if (dir == 'L') {
						d -= 1;
						if (d < 0) {
							d += 4;
						}
					}
					// 오른쪽
					else {
						d += 1;
						d %= 4; // 인덱스가 4이상이면 4로 나눠 나머지를 구함.
					}
					// 머리 이동완료
					map[hx][hy] = d + 1;
					break;
				} else {
					map[hx][hy] = d + 1;
				}
			}
			// print();
			if (out) {
				break;
			}
		}
		System.out.println(answer_time);
	}

//	private static void print() {
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("=====================");
//	}

	public static boolean check(int x, int y) {
		if (x > 0 && x <= N && y > 0 && y <= N) {
			return true;
		}
		return false;
	}
}

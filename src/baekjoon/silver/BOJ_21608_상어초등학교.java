package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_21608_상어초등학교_실버1

public class BOJ_21608_상어초등학교 {
	// map: 교실
	// student: 학생이 좋아하는 학생을 저장
	static int[][] map, student;
	// 교실 크기
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		student = new int[N * N + 1][4];
		for (int n = 0; n < N * N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 4; i++) {
				student[num][i] = Integer.parseInt(st.nextToken());
			}// 입력
			
			// 적합한 위치의 좋아하는 사람의 수와 비어있는 칸의 개수를 저장하는 변수
			int[] max = { 0, 0 };
			// 적합한 위치(좋아하는 사람이 가장 많고, 비어있는 칸이 가장많은 자리)의 좌표
			int max_x = -1, max_y = -1;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					// 빈자리이면
					if (map[i][j] == 0) {
						// 해당 자리 주변에 좋아하는 사람이 얼마나 있고, 비어있는 자리가 얼마나 있는지 조사
						int[] curr = find(i, j, num);
						// 적합한 자리를 찾지 못했거나
						// 이전에 찾았던 자리보다 좋아하는 사람이 주변에 더 많은 자리이거나
						// 이전에 찾았던 자리와 좋아하는 사람이 주변에 있는 수가 같지만, 주변에 빈공간이 더 많은 자리이면 적합한 자리를 해당 자리로 교체
						if ((max_x == -1 && max_y == -1) || curr[0] > max[0]
								|| (curr[0] == max[0] && curr[1] > max[1])) {
							max[0] = curr[0];
							max[1] = curr[1];
							max_x = i;
							max_y = j;
						}
					}
				}
			}
			// 적합한 자리에 학생을 앉힘
			map[max_x][max_y] = num;
		}
		// 만족도 점수 계산
		int sum = 0;
		int[] score = { 0, 1, 10, 100, 1000 };
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += score[find(i, j, map[i][j])[0]];
			}
		}
		System.out.println(sum);
	}

	// 해당 자리 주변에 좋아하는 사람이 얼마나 있고, 비어있는 자리가 얼마나 있는지 조사
	private static int[] find(int x, int y, int num) {
		// 좋아하는 사람 수, 비어있는 자리 수
		int[] cnt = { 0, 0 };
		// 4방
		int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 4방을 조사
		for (int[] d : dir4) {
			int nx = x + d[0];
			int ny = y + d[1];
			// 교실범위에서 벗어났으면 무효
			if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
				continue;
			}
			// 빈자리이면 빈자리수 1증가
			if (map[nx][ny] == 0) {
				cnt[1]++;
			}
			// 아니면 좋아하는 학생인지 셈
			else {
				for (int i = 0; i < 4; i++) {
					if (student[num][i] == map[nx][ny]) {
						cnt[0]++;
					}
				}
			}
		}
		return cnt;
	}
}

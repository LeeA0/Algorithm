package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_사다리조작_15684_골드4
public class BOJ_15684_사다리조작 {
	static int N, M, H, answer;
	static boolean[][] ladder;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		// 사다리의 가로위치를 저장하는 배열
		// N=5, H=8이라하면 이를 연결하는 가로선은 4x8의 형태로 놓을 수 있는 공간이 마련된다
		ladder = new boolean[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}

		answer = 4;
		// 3개 이상이면 -1을 출력하라 했으므로, 0~3개를 새로 놓았을 때만 생각하면 된다
		for (int l = 0; l < 4; l++) {
			put(1, 1, 0, l);
			if (answer != 4) {
				break;
			}
		}

		// answer가 초기 값인 4이면 답이없거나 3개 이하로 해답을 찾을 수 없는 것이므로 -1 출력
		System.out.println(answer == 4 ? -1 : answer);
	}

	// 가로선 놓기
	// r,c: 마지막에 놓았던 가로선의 위치
	// cnt: 현재까지 놓은 가로선의 개수
	// l: 놓으려는 가로선의 개수
	public static void put(int r, int c, int cnt, int l) {
		// 놓은 가로선의 수가 놓으려는 가로선의 개수와 같아지면
		if (cnt == l) {
			// 각 시작 번호가 도착 번호와 같은지 확인한다
			if (go()) {
				// 모두 같다면 answer를 갱신해준다
				answer = l;
			}
			return;
		}
		// 가로선 놓기
		for (int i = r; i <= H; i++) {
			for (int j = c; j < N; j++) {
				// 가로선은 연속으로 존재할 수 없으므로, 현재 위치와 양 옆에 가로선이 없는지 확인
				// 양 옆으로 한 칸씩 더 선언했으므로, index out of bound는 걱정 안해도 됨
				if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
					// 놓는다
					ladder[i][j] = true;
					// 다음 가로선을 놓는다
					put(i, j, cnt + 1, l);
					// 놓았던 가로선을 제거한다
					ladder[i][j] = false;
				}
			}
			// 행의 순환이 끝나면 다음 행으로 이동할 때 열 값을 1로 초기화
			c=1;
		}
	}

	// 각 시작 번호가 도착 번호와 같은지 확인
	public static boolean go() {
		// 1번부터 N번까지 제대로 도착하나 확인
		for (int curr = 1; curr <= N; curr++) {
			// 사다리를 타기위해 위치를 저장하는 변수 r,c
			// 번호의 맨 처음 위치로 초기화
			int r = curr;
			int c = 0;
			// 이동을 시작
			while (true) {
				// 이동할 수 있는 사다리가 있으면
				for (int i = c + 1; i <= H; i++) {
					// 현재 위치보다 -1 작은 번호에 사다리가 있으면 왼쪽으로 이동
					if (ladder[i][r - 1]) {
						c = i;
						r--;
						break;
					}
					// 현재 위치와 같은 번호에 사다리가 있으면 오른족으로 이동
					if (ladder[i][r]) {
						c = i;
						r++;
						break;
					}
					// 맨 끝에 왔다
					if (i == H) {
						c = H;
					}
				}
				// 끝에 까지 도달했으면
				if (c == H) {
					break;
				}
			}
			// 시작번호와 끝번호가 다르면 false
			if (r != curr) {
				return false;
			}
		}
		// 모든 번호의 시작번호와 끝번호가 같으면 true
		return true;
	}
}

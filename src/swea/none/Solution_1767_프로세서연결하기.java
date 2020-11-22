package swea.none;

import java.io.BufferedReader;
//1차시도 -> 막짜보기 -> 망
//2차시도 -> pq이용 -> 망
//3차시도 -> 김태희교수님 코드 들은 후 공부
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//SW_프로세서 연결하기_1767
public class Solution_1767_프로세서연결하기 {

	// min_line : 최대한 많은 코어를 연결한 최소전선길이
	// max_core : 전선이 연결된 최대 코어 수
	// coreNum : 전선을 연결해줄수 있는 코어의 총 개수
	static int T, N, min_line, max_core, coreNum;
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 코어를 저장하는 리스트
	static LinkedList<Core> corelist;

	static class Core {
		int x;
		int y;

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];

			corelist = new LinkedList<>();
			coreNum = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i > 0 && i < N - 1 && j > 0 && j < N - 1) {
							corelist.add(new Core(i, j));
							coreNum++;
						}
					}
				}
			}
			max_core = 0;
			min_line = Integer.MAX_VALUE;

			// 코어 1~N개를 깔 수 있다!
			subset(0, 0);

			System.out.println("#" + t + " " + min_line);
		}
	}

	// index : 현재 코어, cnt : 현재까지 전선을 연결해준 코어의 수
	public static void subset(int index, int cnt) {
		// 모든코어 처리를 끝냈을 때
		if (index == coreNum) {
			int linelength = getLineLength();
			if (max_core < cnt) {
				max_core = cnt;
				min_line = linelength;
			} else if (max_core == cnt) {
				min_line = Math.min(min_line, linelength);
			}
			return;
		}

		Core curr = corelist.get(index);
		// 4방향 중 한 방향으로 전선깔기를 시도
		for (int[] d : dir4) {
			// 전선을 놓을 수 있으면
			if (can(curr, d)) {
				// 전선을 놓는다.
				put(curr, d, 2);
				// 다음코어로 간다
				subset(index + 1, cnt + 1);
				// 전선을 제거한다.
				put(curr, d, 0);
			}
		}
		// 이번 코어에는 어떠한 전선도 깔지 않고 다음 코어로 넘어간다.
		subset(index + 1, cnt);
	}

	public static int getLineLength() {
		int length = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					length++;
				}
			}
		}
		return length;
	}

	public static void put(Core curr, int[] d, int s) {
		int nx = curr.x;
		int ny = curr.y;
		while (true) {
			nx += d[0];
			ny += d[1];
			if (!check(nx, ny)) {
				break;
			}
			map[nx][ny] = s;
		}
	}

	public static boolean can(Core curr, int[] d) {
		int nx = curr.x;
		int ny = curr.y;
		while (true) {
			nx += d[0];
			ny += d[1];
			if (!check(nx, ny)) {
				break;
			}
			if (map[nx][ny] >= 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}
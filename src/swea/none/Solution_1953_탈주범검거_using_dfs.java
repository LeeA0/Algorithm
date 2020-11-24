package swea.none;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// visited는 꼭 int형으로 처리해야한다..! boolean으로하면 전부 못 돌아서 답이 모자라게 나온다!
// SW_탈주범검거_1953
public class Solution_1953_탈주범검거_using_dfs {
	static int T, N, M, R, C, L;
	static int[][] map;
	static int[][] visited;
	// 상좌하우
	static int[][] dir4 = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static String[] pipe = { null, "0123", "02", "13", "03", "23", "12", "01" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new int[N][M];

			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료

			dfs(R, C, 1);

			System.out.println("#" + t + " " + getAnswer());
		}
	}

	public static int getAnswer() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != Integer.MAX_VALUE) {
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, int t) {
		visited[x][y] = t;
		// print(t);

		if (t == L) {
			return;
		}

		// String을 숫자 배열로 변환
		char[] dir_char = pipe[map[x][y]].toCharArray();
		int[] dir = new int[dir_char.length];
		for (int i = 0; i < dir_char.length; i++) {
			dir[i] = dir_char[i] - '0';
		}

		for (int d : dir) {
			int nx = x + dir4[d][0];
			int ny = y + dir4[d][1];
			if (check(nx, ny) && map[nx][ny] != 0 && visited[nx][ny] > t
					&& pipe[map[nx][ny]].contains((d + 2) % 4 + "")) {
				dfs(nx, ny, t + 1);
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

}

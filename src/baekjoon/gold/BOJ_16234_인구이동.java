package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_인구이동_16234_골드5
public class BOJ_16234_인구이동 {
	static int N, R, L, count;
	static boolean flag;
	static int[][] country, checked;
	static int[] save_people;
	static int[][] dir4 = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 끝
		flag = true;
		while (flag) {
			checked = new int[N][N];
			flag = false;
			count++;
			int check_num = 1;
			save_people = new int[N * N + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (checked[i][j] == 0) {
						// 국경 체크
						bfs(i, j, check_num++);
					}
				}
			}
			// 인구이동
			// 다 체크한 후에 한 번에 값을 바꾸는 것이 시간 절약할 수 있음
			move();
		}
		System.out.println(count - 1);
	}

	static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				country[i][j] = save_people[checked[i][j]];
			}
		}
	}

	static void bfs(int x, int y, int check_num) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		checked[x][y] = check_num;
		int cnt = 1;
		int sum = country[x][y];
		boolean[][] union = new boolean[N][N];
		union[x][y] = true;

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny) || checked[nx][ny] != 0 || union[nx][ny]) {
					continue;
				}
				int diff = Math.abs(country[curr[0]][curr[1]] - country[nx][ny]);
				if (L <= diff && diff <= R) {
					flag = true;
					que.offer(new int[] { nx, ny });
					checked[nx][ny] = check_num;
					cnt++;
					sum += country[nx][ny];
					union[nx][ny] = true;
				}
			}
		}

		save_people[check_num] = sum / cnt;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

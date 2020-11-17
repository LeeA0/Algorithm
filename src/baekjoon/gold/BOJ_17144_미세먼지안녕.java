package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준_미세먼지 안녕!_17144_골드5
public class BOJ_17144_미세먼지안녕 {
	static int R, C, T;
	static int[][] map;
	// 우,상,좌,하
	static int[][] dir4 = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	// 우,하,좌,상
	static int[][] dir4_down = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static ArrayList<int[]> fresh;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		fresh = new ArrayList<int[]>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					fresh.add(new int[] { i, j });
				}
			}
		}

		for (int t = 0; t < T; t++) {
			spread();
			rotation();
		}
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					answer += map[i][j];
			}
		}
		System.out.println(answer);
	}

	public static void rotation() {
		int[][] temp = new int[R][C];
		copy(temp,map);
		
		// 위 공기순환
		int nx = fresh.get(0)[0];
		int ny = fresh.get(0)[1];
		for (int[] d : dir4) {
			while (true) {
				nx += d[0];
				ny += d[1];
				if (!check(nx, ny) || map[nx][ny] == -1) {
					nx -= d[0];
					ny -= d[1];
					break;
				}
				if (map[nx - d[0]][ny - d[1]] == -1) {
					temp[nx][ny] = 0;
				} else {
					temp[nx][ny] = map[nx - d[0]][ny - d[1]];
				}
			}
		}

		// 아래 공기순환
		nx = fresh.get(1)[0];
		ny = fresh.get(1)[1];
		for (int[] d : dir4_down) {
			while (true) {
				nx += d[0];
				ny += d[1];
				if (!check(nx, ny) || map[nx][ny] == -1) {
					nx -= d[0];
					ny -= d[1];
					break;
				}
				if (map[nx - d[0]][ny - d[1]] == -1) {
					temp[nx][ny] = 0;
				} else {
					temp[nx][ny] = map[nx - d[0]][ny - d[1]];
				}
			}
		}

		// temp배열을 map에 깊은 복사
		copy(map,temp);
	}

	public static void copy(int[][] m, int[][] t) {
for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				m[i][j] = t[i][j];
			}
		}
	}

	public static void spread() {
		int[][] temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 공기청정기가 아니고 먼지가 있는 곳
				if (map[i][j] != 0 && map[i][j] != -1) {
					int dust = map[i][j] / 5;
					for (int[] d : dir4) {
						int nx = i + d[0];
						int ny = j + d[1];
						if (!check(nx, ny) || map[nx][ny] == -1) {
							continue;
						}
						temp[nx][ny] += dust;
						temp[i][j] -= dust;
					}
				}
			}
		}
		// map에 temp값 더하기!
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 & x < R && y >= 0 && y < C) {
			return true;
		}
		return false;
	}

//	public static void print(int[][] m) {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(m[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}

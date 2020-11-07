package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// nCr로 풀었지만 nPr이 더 좋아 보임.
// 백준_십자가놓기_17085_실버1
public class BOJ_17085_십자가놓기_using_nCr {
	static int N, M, answer;
	static char[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		LinkedList<int[]> shop1 = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '#') {
					shop1.add(new int[] { i, j });
				}
			}
		} // 입력 완료

		answer = 0;

		nCr(0, 0, new int[2][2], shop1);

		LinkedList<int[]> shop2 = new LinkedList<int[]>();
		for (int i = shop1.size() - 1; i >= 0; i--) {
			shop2.add(shop1.get(i));
		}
		nCr(0, 0, new int[2][2], shop2);

		System.out.println(answer);
	}

	private static void nCr(int start, int cnt, int[][] save, LinkedList<int[]> shop) {
		if (cnt == 2) {
			boolean[][] cross = new boolean[N][M];
			boolean can = true;
			int area = 1;

			for (int[] s : save) {
				// 십자가의 중앙이 다른 십자가와 겹치면 break;
				if (cross[s[0]][s[1]]) {
					can = false;
					break;
				}
				
				// 최대 십자가 크기 구하기
				int size = Integer.MAX_VALUE;
				for (int[] d : dir4) {
					int nx = s[0];
					int ny = s[1];
					int count = 0;
					while (true) {
						nx += d[0];
						ny += d[1];
						if (!check(nx, ny) || map[nx][ny] == '.' || cross[nx][ny] || size == count) {
							size = count;
							break;
						}
						count++;
					}
				}
				
				//방문 처리
				cross[s[0]][s[1]] = true;
				for (int[] d : dir4) {
					int nx = s[0];
					int ny = s[1];
					for (int i = 0; i < size; i++) {
						nx += d[0];
						ny += d[1];
						if (!check(nx, ny) || map[nx][ny] == '.' || cross[nx][ny]) {
							break;
						}
						cross[nx][ny]=true;
					}
				}

				// 넓이 곱
				area *= (1 + size * 4);
			}
			if (can) {
				answer = Math.max(answer, area);
			}

			return;
		}
		for (int i = start; i < shop.size(); i++) {
			save[cnt] = shop.get(i);
			nCr(i + 1, cnt + 1, save, shop);
		}
	}

	private static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}

package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준_색종이2_2567_실버5
public class BOJ_2567_색종이2 {
	static int[][] map;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 제일 작은 x,y값과 제일 큰 x,y값을 저장
	static int minx, miny, maxx, maxy;
	static int answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[101][101];
		int N = scan.nextInt();

		minx = Integer.MAX_VALUE;
		miny = Integer.MAX_VALUE;
		maxx = Integer.MIN_VALUE;
		maxy = Integer.MIN_VALUE;

		// 색종이 입력
		for (int k = 0; k < N; k++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			minx = Math.min(minx, a);
			miny = Math.min(miny, b);
			maxx = Math.max(maxx, a + 10);
			maxy = Math.max(maxy, b + 10);
			for (int i = a; i < a + 10; i++) {
				for (int j = b; j < b + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		answer = 0;

		for (int i = minx; i < maxx; i++) {
			for (int j = miny; j < maxy; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < maxx; i++) {
			for (int j = 0; j < maxy; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		// 방문표시
		map[x][y] = 2;
		while (!que.isEmpty()) {
			// 옆에 공백이 몇개인지 count
			int count = 0;
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == 1) {
					que.offer(new int[] { nx, ny });
					map[nx][ny] = 2;
					count++;
				}
				else if (map[nx][ny] == 2) {
					count++;
				}
			}
			if (count == 3) {
				answer++;
			} else if (count == 2) {
				answer += 2;
			}
		}
	}

	private static boolean check(int x, int y) {
		if (x >= minx && x < maxx && y >= miny && y < maxy) {
			return true;
		}
		return false;
	}
}

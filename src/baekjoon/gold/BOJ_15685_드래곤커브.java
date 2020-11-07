package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_드래곤커브_15685_골드4
public class BOJ_15685_드래곤커브 {
	static int N, answer;
	// ######### < 문제 x,y기준 => 좌우 : x 상하 : y > ##########
	// 0:우 (x좌료 증가)
	// 1:상 (y좌표 감소)
	// 2:좌 (x좌표 감소)
	// 3:하 (y좌표 증가)
	static int[][] dir4 = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static LinkedList<Integer> dir_save; // 방향을 저장할 리스트
	static boolean[][] map; // 점을 표시할 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new boolean[101][101];
		answer = 0;

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken()); // 초기 x좌표
			int y = Integer.parseInt(st.nextToken()); // 초기 y좌표
			int d = Integer.parseInt(st.nextToken()); // 초기 방향
			int g = Integer.parseInt(st.nextToken()); // 세대

			dir_save = new LinkedList<Integer>();
			dir_save.add(d);

			for (int i = 1; i <= g; i++) {
				for (int j = dir_save.size() - 1; j >= 0; j--) {
					int temp = dir_save.get(j);
					dir_save.add((temp + 1) % 4);
				}
			}
			// 이동하면서 point를 저장
			move(y, x);
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					findSquare(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void findSquare(int y, int x) {
		// 현재위치는 맨왼쪽위라는 가정하에
		int[][] square = {{1,0},{0,1},{1,1}};
		int cnt = 0;
		for (int[] s: square) {
			if(map[y+s[0]][x+s[1]]) {
				cnt++;;
			}
		}
		if(cnt==3) {
			answer++;
		}
	}

	private static void move(int y, int x) {
		map[y][x] = true;
		int nx = x;
		int ny = y;
		for (int i = 0; i < dir_save.size(); i++) {
			int d = dir_save.get(i);
			ny += dir4[d][0];
			nx += dir4[d][1];
			map[ny][nx] = true;
		}
	}
}

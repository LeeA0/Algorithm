package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준_적록색약_10026_골드5
public class BOJ_10026_적록색약 {
	static int N;
	// 적록색약이 아닌 사람을 위한 맵
	// 적록색약을 위한 맵
	static char[][] map1;
	static char[][] map2;
	// 적,녹,청 개수세는 변수
	// 적-녹, 청 개수세는 변수
	static int cnt1, cnt2;
	// 상 하 좌 우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map1 = new char[N][N];
		map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				map1[i][j] = temp[j];
				map2[i][j] = temp[j];	
			}
		}

		//적록색약이 아닌경우
		cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map1[i][j] != '0') {
					bfs(i, j, map1, map1[i][j], 1);
				}
			}
		}

		//적록색약인 경우
		cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] != '0') {
					bfs(i, j, map2, map2[i][j], 2);
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);
	}

	// x, y : 탐색을 시작할 초기위치 
	// map : 탐색할 맵(map1,map2)
	// color : 처음 시작위치의 색
	// version : 적록색약아닌경우(1), 적록색약(2)
	public static void bfs(int x, int y, char[][] map, char color, int version) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { x, y });
		map[x][y] = '0';
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0] + d[0];
				int ny = curr[1] + d[1];
				if (!checked(nx, ny)) {
					continue;
				}
				// 적록색약이 아닌사람
				if (map[nx][ny] != '0' && version == 1) {
					if (map[nx][ny] == color) {
						que.offer(new int[] { nx, ny });
						map[nx][ny] = '0';
					}
				} 
				// 적록색약인 사람
				else if (map[nx][ny] != '0' && version == 2) {
					// 색깔이 G또는 R일 때
					if (color == 'G' || color == 'R') {
						if (map[nx][ny] == 'G' || map[nx][ny] == 'R') {
							que.offer(new int[] { nx, ny });
							map[nx][ny] = '0';
						}
					} 
					// 색깔이 B일 때
					else {
						if (map[nx][ny] == color) {
							que.offer(new int[] { nx, ny });
							map[nx][ny] = '0';
						}
					}
				}
			}
		}
		// 적록색약이 아닌사람 개수
		if (version == 1) {
			cnt1++;
		} 
		// 적록색약인 사람 영역 개수
		else if (version == 2) {
			cnt2++;
		}
	}

	public static boolean checked(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}

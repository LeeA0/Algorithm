package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_게리멘더링2_17779_골드4
public class BOJ_17779_게리멘더링2 {
	static int N;
	static int[][] map;
	// 상하좌우
	static int[][] dir4 = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	// 대각선
	static int[][] dir4_dia = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료

		int answer = 40001;

		for (int x = 1; x < N; x++) {
			for (int y = 1; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 <= N && 0 <= y - d1 && y + d2 < N) {
							answer = Math.min(answer, getPersonDiff(getFiveMap(x, y, d1, d2)));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	public static boolean[][] getFiveMap(){
		
	}
	
	public static int getPersonDiff(boolean[][] fiveMap) {
		int personDiff = 0;
		
		
		return personDiff;
	}
}

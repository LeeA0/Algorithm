package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준_파이프옮기기1_17070_골드5
public class BOJ_17070_파이프옮기기1 {
	static int N;
	static boolean[][] map;
	static int[][][] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
				}
			}
		}
		
		check = new int[N][N][3];
		
		// 맨처음 파이프 놓기
		// 맨마지막칸의 0번째 배열은 오른쪽의 개수
		// 1번째 배열은 대각선의 개수
		// 2번째 배열은 아래 방향의 개수
		check[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			// 어처피 방향상 1보다 왼쪽으로 갈수는 없음.
			for (int j = 1; j < N; j++) {
				// 오른쪽
				if(check(i,j+1)&&!map[i][j+1]){
					check[i][j+1][0] += check[i][j][0]+check[i][j][1];
				}
				// 대각선
				if(check(i+1,j)&&check(i+1,j+1)&&check(i,j+1)&&!map[i+1][j]&&!map[i+1][j+1]&&!map[i][j+1]) {
					check[i+1][j+1][1] += check[i][j][0]+check[i][j][1]+check[i][j][2];
				}
				// 아래쪽
				if(check(i+1,j)&&!map[i+1][j]){
					check[i+1][j][2] += check[i][j][1]+check[i][j][2];
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum+=check[N-1][N-1][i];
		}
		System.out.println(sum);
	}

	private static boolean check(int x, int y) {
		if(x>=0&&x<N&&y>=0&&y<N) {
			return true;
		}
		return false;
	}
}
